package com.springboot.demo.util;

import com.google.gson.Gson;

/**
 * <p>Title: RestUriConstants </p>
 * <p>Description: TODO </p>
 * Date: 2018年3月5日 下午3:14:40
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年3月5日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class RestUriConstants {
	public static final Gson YUNWEI_GSON = new Gson();
	/**
	 * <p>Title: LangChaoRestURIConstants </p>
	 * <p>Description: Constructor </p>  
	 */
	private RestUriConstants() {
	}

	/**
	 * 获取所有用户
	 */
	public static final String ALL_USERS = "/users/all";
	/**
	 * 测试异常
	 */
	public static final String TEST_EXCEPTION = "/test/exception";
	/**
	 * 每日值班
	 */
	public static final String ONDUTY = "/onduty/time/{time}/pageSize/{pageSize}/currentPage/{currentPage}";
}
