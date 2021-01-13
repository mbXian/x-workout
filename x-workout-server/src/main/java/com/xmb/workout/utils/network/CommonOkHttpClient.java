package com.xmb.workout.utils.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonOkHttpClient {

	private static OkHttpClient mClient;

	static {
		OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
		clientBuilder.connectTimeout(30, TimeUnit.SECONDS);
		clientBuilder.readTimeout(30, TimeUnit.SECONDS);
		clientBuilder.writeTimeout(30, TimeUnit.SECONDS);
		// 允许重定向
		clientBuilder.followRedirects(true);

		// https支持
		clientBuilder.hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String s, SSLSession sslSession) {
				return true;
			}
		});
		mClient = clientBuilder.build();
	}

	public static Response sendRequest(Request request) throws IOException {
		Response response = mClient.newCall(request).execute();
		return response;
	}

}

