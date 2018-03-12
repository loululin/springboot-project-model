/**
 * 
 */
package com.springboot.demo.okhttp3;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * <p>Title: OkHttpRequestUtil </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午5:35:56
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class OkHttpRequestUtil {
	private static final MediaType TYPE_JSON = MediaType
			.parse("application/json;charset=utf-8");

	private OkHttpRequestUtil() {
	}

	/**
	 * @param url
	 * @param jsonStr
	 * @return
	 */
	public static Request buildPostJsonRequest(String url, String jsonStr) {
		RequestBody requestBody = RequestBody.create(TYPE_JSON, jsonStr);
		Request request = new Request.Builder().url(url).post(requestBody)
				.build();
		return request;
	}

	/**
	 * @param url
	 * @return
	 */
	public static Request buildGetRequest(String url) {
		return new Request.Builder()
				.url(url).get().build();
	}

}
