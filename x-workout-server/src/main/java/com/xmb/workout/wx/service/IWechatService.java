package com.xmb.workout.wx.service;

import com.xmb.workout.wx.entity.WechatAccessToken;
import com.xmb.workout.wx.entity.WechatCode2Session;

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

}
