package com.xmb.workout.utils.network;

import com.alibaba.fastjson.JSONObject;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import java.util.Map;

public class CommonOkhttpRequest {

	public static Request createPostRequest(String url, JSONObject paramsJSONObject) {

		// 添加参数
		if (paramsJSONObject != null) {
			RequestBody requestBody = FormBody.create(MediaType.parse("application/json"), paramsJSONObject.toJSONString());
			// 创建request
			return new Request.Builder().post(requestBody).url(url).build();
		} else {
			// 创建request
			return new Request.Builder().url(url).build();
		}
	}

	public static Request createGetRequest(String url, RequestParams params) {
		// 如果params不为空，构建新的url
		if (params != null) {
			StringBuilder stringBuilder = new StringBuilder(url).append("?");
			for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
				stringBuilder.append(entry.getKey())
					.append("=")
					.append(entry.getValue())
					.append("&");
			}
			// 去除最后的&
			url = stringBuilder.substring(0, stringBuilder.length() - 1);
		}
		return new Request.Builder().url(url).get().build();
	}

}
