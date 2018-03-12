package com.springboot.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserMapper </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月13日 下午4:55:57
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月13日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public interface UserMapper {
	
	
	/**
	 * <p>Title: getUsers </p>
	 * <p>Description: 获取所有用户</p>
	 * @return
	 */
	List<Map<String, Object>> getUsers();
	
}
