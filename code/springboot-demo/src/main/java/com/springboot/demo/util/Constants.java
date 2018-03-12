package com.springboot.demo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * <p>Title: LangChaoConstants </p>
 * <p>Description: 项目常量类 </p>
 * Date: 2017年7月13日 下午1:29:32
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月13日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public final class Constants {
	
	
	/**
	 * <p>Title: LangChaoConstants </p>
	 * <p>Description: Constructor </p>  
	 */
	private Constants() {
	}
	
	
	public static final String MSG_SUCCESS = "success";
	public static final String MSG_FALSE = "failure";
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_FALSE = 0;
	
	public static final Gson COMM_GSON = new Gson();
	
	/**
	 * <p>Title: getPageInfo </p>
	 * <p>Description: 获取分页返回信息 </p>
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getPageInfo(Map<String, Object> params){
		Map<String, Object> userInfo = new LinkedHashMap<>();
		
		int totalPage = 0;
		int allRows = (int) params.get("totalCount");
		int pageSize = (int) params.get("pageSize");
		if (allRows % pageSize > 0) {
			totalPage = allRows / pageSize + 1;
		} else if (allRows % pageSize == 0) {
			totalPage = allRows / pageSize;
		}
		userInfo.put("totalPage", totalPage);
		userInfo.put("totalCount", allRows);
		userInfo.put("currentPage", params.get("currentPage"));
		return userInfo;
	}
	
	
	
	/**
	 * <p>Title: getCurrentTimeSeconds </p>
	 * <p>Description: 用于前端实时获取后端服务器的时间，精确到分钟 </p>
	 * @param params
	 * @return
	 */
	public static String getCurrentTimeSeconds(){
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");  
        return sdf.format(now.getTime());  
	}

}
