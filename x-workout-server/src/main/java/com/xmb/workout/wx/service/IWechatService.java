package com.xmb.workout.wx.service;

import com.xmb.workout.wx.entity.WechatAccessToken;
import com.xmb.workout.wx.entity.WechatCode2Session;
import com.xmb.workout.wx.vo.WxRunDataVO;

/**
 * 微信公众号 服务类
 */
public interface IWechatService {

	/**
	 * 获取access_token
	 */
	WechatAccessToken getAccessToken();

	/**
	 * 登录凭证校验
	 */
	WechatCode2Session getSession(String jsCode);

	/**
	 * 解密微信运动数据
	 * @param openId
	 * @param encryptedData
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	WxRunDataVO decryptRunData(String openId, String encryptedData, String iv) throws Exception;

}
