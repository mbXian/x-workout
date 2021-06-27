package com.xmb.workout.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmb.common.utils.RedisUtils;
import com.xmb.workout.constant.WechatConstant;
import com.xmb.workout.utils.network.CommonOkHttpClient;
import com.xmb.workout.utils.network.CommonOkhttpRequest;
import com.xmb.workout.utils.network.RequestParams;
import com.xmb.workout.wx.entity.WechatAccessToken;
import com.xmb.workout.wx.entity.WechatCode2Session;
import com.xmb.workout.wx.service.IWechatService;
import com.xmb.workout.wx.vo.WxRunDataVO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号 服务实现类
 */
@Slf4j
@Service
public class WechatServiceImpl implements IWechatService {

	@Autowired
	private RedisUtils redisUtils;
	@Value("${wechat.appId}")
	private String appId;
	@Value("${wechat.appSecret}")
	private String appSecret;

	/**
	 * 获取access_token
	 */
	@Override
	public WechatAccessToken getAccessToken() {
		WechatAccessToken wechatAccessToken = redisUtils.get(WechatConstant.WECHAT_ACCESS_TOKEN_KEY, WechatAccessToken.class);
		if (wechatAccessToken != null) {
			return wechatAccessToken;
		}
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		Map<String, String> params = new HashMap<>();
		params.put(WechatConstant.GRANT_TYPE, WechatConstant.CLIENT_CREDENTIAL);
		params.put(WechatConstant.APPID, appId);
		params.put(WechatConstant.SECRET, appSecret);
		try {
			Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, new RequestParams(params)));
			if (response != null && response.body() != null) {
				String result = response.body().string();
				JSONObject resJSONObject = JSON.parseObject(result);
				String accessToken = resJSONObject.getString(WechatConstant.ACCESS_TOKEN);
				Long expiresIn = resJSONObject.getLong(WechatConstant.EXPIRES_IN);
				wechatAccessToken = new WechatAccessToken();
				wechatAccessToken.setAccessToken(accessToken);
				wechatAccessToken.setExpiresIn(expiresIn);
				//保存到redis
				redisUtils.set(WechatConstant.WECHAT_ACCESS_TOKEN_KEY, wechatAccessToken, WechatConstant.ACCESS_TOKEN_REDIS_EXPIRE_SECONDS);
				return wechatAccessToken;
			}
		} catch (Exception e) {
			log.error("获取微信access_token失败：" + e.getMessage());
		}
		return null;
	}

	/**
	 * 登录凭证校验(code获取openId)
	 * 通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
	 */
	@Override
	public WechatCode2Session getSession(String jsCode) {
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> params = new HashMap<>();
		params.put(WechatConstant.JS_CODE, jsCode);
		params.put(WechatConstant.GRANT_TYPE, WechatConstant.AUTHORIZATION_CODE);
		params.put(WechatConstant.APPID, appId);
		params.put(WechatConstant.SECRET, appSecret);
		String result = null;
		try {
			Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, new RequestParams(params)));
			if (response != null && response.body() != null) {
				result = response.body().string();
				JSONObject resJSONObject = JSON.parseObject(result);
				String openId = resJSONObject.getString(WechatConstant.OPENID);
				String session_key = resJSONObject.getString(WechatConstant.SESSION_KEY);
				String unionid = resJSONObject.getString(WechatConstant.UNIONID);
				int errcode = resJSONObject.getIntValue(WechatConstant.ERRCODE);
				String errmsg = resJSONObject.getString(WechatConstant.ERRMSG);
				WechatCode2Session wechatCode2Session = new WechatCode2Session();
				wechatCode2Session.setOpenId(openId);
				wechatCode2Session.setSessionKey(session_key);
				wechatCode2Session.setUnionId(unionid);
				wechatCode2Session.setErrcode(errcode);
				wechatCode2Session.setErrMsg(errmsg);

				redisUtils.set(WechatConstant.WECHAT_SESSION_KEY + openId, wechatCode2Session, WechatConstant.SESSION_KEY_REDIS_EXPIRE_SECONDS);
				return wechatCode2Session;
			}
		} catch (Exception e) {
			log.error("code换取openId失败：" + e.getMessage() + ", result = " + result);
		}
		return null;
	}

	public WxRunDataVO decryptRunData(String openId, String encryptedData, String iv) throws Exception {
		WxRunDataVO wxRunDataVO = null;
		WechatCode2Session wechatCode2Session = redisUtils.get(WechatConstant.WECHAT_SESSION_KEY + openId, WechatCode2Session.class);
		if (wechatCode2Session != null) {
			String sessionkey = wechatCode2Session.getSessionKey();
			System.out.println("encryptedData = " + encryptedData);
			System.out.println("sessionkey = " + sessionkey);
			System.out.println("iv = " + iv);
			// 被加密的数据
			byte[] dataByte = Base64.getDecoder().decode(encryptedData);
			// 加密秘钥
			byte[] keyByte = Base64.getDecoder().decode(sessionkey);
			// 偏移量
			byte[] ivByte = Base64.getDecoder().decode(iv);
			try {
				// 如果密钥不足16位，那么就补足
				int base = 16;
				if (keyByte.length % base != 0) {
					int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
					byte[] temp = new byte[groups * base];
					Arrays.fill(temp, (byte) 0);
					System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
					keyByte = temp;
				}
				// 初始化
				Security.addProvider(new BouncyCastleProvider());
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
				SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
				AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
				parameters.init(new IvParameterSpec(ivByte));
				cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
				byte[] resultByte = cipher.doFinal(dataByte);
				if (null != resultByte && resultByte.length > 0) {
					String result = new String(resultByte, "UTF-8");
					System.out.println("result:"+result);
					wxRunDataVO = WxRunDataVO.parseFromJsonString(result);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		return wxRunDataVO;
	}


}
