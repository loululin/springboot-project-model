package com.springboot.demo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.springboot.demo.dao.UserMapper;
import com.springboot.demo.util.Constants;


/**
 * <p>Title: UserService </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午2:13:01
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Service
public class UserService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @return
	 */
	@Cacheable(value="baseCache")
	@Transactional(readOnly=true,rollbackFor=Exception.class)
	public Map<String, Object> getAllUsers(){
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			//测试缓存生效所用
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			LOGGER.error("getAllUsers exception", e1.getMessage());
		}
		try {
			response.put("code", Constants.CODE_SUCCESS);
			response.put("msg", Constants.MSG_SUCCESS);
			response.put("result", userMapper.getUsers());
		} catch (Exception e) {
			LOGGER.error("获取所有用户 异常", e);
			response.put("code", Constants.CODE_FALSE);
			response.put("msg", Constants.MSG_FALSE);
		}
		LOGGER.debug("UserService.getResult() response is  :  " + Constants.COMM_GSON.toJson(response));
		return response;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> getUsersByPage(){
		Map<String, Object> result = Maps.newHashMapWithExpectedSize(2);
		PageHelper.startPage(2, 3);
		List<Map<String, Object>> usersTemp =  userMapper.getUsers();
		result.put("users", usersTemp);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(usersTemp);
		result.put("pageInfo", page);
		return result;
	}
	

}
