package com.xmb.workout.wx.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 微信登录获取openId
 */
@Data
public class WechatCode2Session {

	@ApiModelProperty("用户唯一标识")
	private String openId;

	@ApiModelProperty("会话密钥")
	private String sessionKey;

	@ApiModelProperty("用户在开放平台的唯一标识符")
	private String unionId;

	@ApiModelProperty("错误码")
	private int errcode;

	@ApiModelProperty("错误信息")
	private String errMsg;

}
