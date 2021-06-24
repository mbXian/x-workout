package com.xmb.workout.wx.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 微信access_token 实体类
 */
@Data
public class WechatAccessToken {

	@ApiModelProperty("accessToken凭证")
	private String accessToken;

	@ApiModelProperty("凭证有效时间，单位：秒")
	private long expiresIn;

}
