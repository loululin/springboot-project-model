/**
 * 
 */
package com.springboot.demo.okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title: OkHttpUtil </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午5:34:57
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class OkHttpUtil {
	private static OkHttpClient singleton;
	private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtil.class);
	private OkHttpUtil() {
	}
	
	/**
	 * <p>Title: getInstance </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public static OkHttpClient getInstance() {
		if (null == singleton) {
			synchronized (OkHttpUtil.class) {
				if (null == singleton) {
					singleton = new OkHttpClient.Builder()
							.connectTimeout(30, TimeUnit.SECONDS)
							.readTimeout(30, TimeUnit.SECONDS)
							.writeTimeout(30, TimeUnit.SECONDS)
							.retryOnConnectionFailure(true)
							.build();
				}
			}
		}
		return singleton;
	}
	/**
	 * <p>Title: getStringFromServer </p>
	 * <p>Description: 通过 url获取string  get请求 </p>
	 * @param url
	 * @return
	 */
	public static String getStringFromServer(String url) {
		String result = "";
		try {
			Response response = getInstance()
					.newCall(OkHttpRequestUtil.buildGetRequest(url)).execute();
			
			if (!response.isSuccessful()) {
				throw new IOException("服务器端错误:" + response);
			}
			result = response.body().string();
		} catch (IOException e) {
			LOGGER.error("getStringFromServer occor error: ",e);
		}
		return result;
	}
	
	/**
	 * <p>Title: getStringFromServerByPost </p>
	 * <p>Description: 通过 url和parameterJsonType获取string  post请求 </p>
	 * @param url
	 * @param parameterJsonType
	 * @return
	 */
	public static String getStringFromServerByPost(String url,String parameterJsonType) {
		String result = "";
		try {
			Response response = getInstance()
					.newCall(OkHttpRequestUtil.buildPostJsonRequest(url,parameterJsonType)).execute();
			
			if (!response.isSuccessful()) {
				throw new IOException("服务器端错误:" + response);
			}
			result = response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("getDongHuanInfo error: ",e);
		}
		return result;
	}

}
