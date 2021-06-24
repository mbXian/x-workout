package com.xmb.workout.constant;

/**
 * 微信常量
 */
public interface WechatConstant {

	String ACCESS_TOKEN = "access_token";
	String GRANT_TYPE = "grant_type";
	String APPID = "appid";
	String SECRET = "secret";
	String EXPIRES_IN = "expires_in";
	String CLIENT_CREDENTIAL = "client_credential";
	String JS_CODE = "js_code";
	String AUTHORIZATION_CODE = "authorization_code";
	String OPENID = "openid";
	String SESSION_KEY = "session_key";
	String UNIONID = "unionid";
	String ERRCODE = "errcode";
	String ERRMSG = "errmsg";
	String USERID = "userid";
	String NAME = "name";
	String POSITION = "position";
	String MOBILE = "mobile";
	String GENDER = "gender";
	String EMAIL = "email";
	String WEIXINID = "weixinid";
	String AVATAR = "avatar";
	String STATUS = "status";
	String TICKET = "ticket";
	String TYPE = "type";
	String JSAPI = "jsapi";
	String CORPID = "corpid";
	String CORPSECRET = "corpsecret";
	String CODE = "code";
	String WECHAT_WORK_USERID = "UserId";
	String WECHAT_WORK_OPENID = "OpenId";
	String ERROR_MSG_SET_TAG = "请配置应用标签";
	String MEDIA_ID = "media_id";
	String INVALID_USER = "invaliduser";
	String INVALID_PARTY = "invalidparty";
	String INVALID_TAG = "invalidtag";

	String WECHAT_ACCESS_TOKEN_KEY = "wechat:access_token";
	String WECHAT_WORK_ACCESS_TOKEN_KEY = "blade:wechat_work:access_token:";
	long ACCESS_TOKEN_REDIS_EXPIRE_SECONDS = 7000L;

	String WECHAT_WORK_JSAPI_TICKET_KEY = "blade:wechat_work:jsapi_ticket:";
	String WECHAT_JSAPI_TICKET_KEY = "blade:wechat:jsapi_ticket:";
	long JSAPI_TICKET_REDIS_EXPIRE_SECONDS = 7000L;
	long WECHAT_WORK_JSAPI_TICKET_REDIS_EXPIRE_SECONDS = 7000L;

	String WECHAT_CONFIG_KEY = "blade:wechat:config:";
	long WECHAT_CONFIG_REDIS_EXPIRE_SECONDS = 86400L;

}
