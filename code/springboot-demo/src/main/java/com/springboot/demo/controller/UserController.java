package com.springboot.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.service.UserService;
import com.springboot.demo.util.RestUriConstants;

import io.swagger.annotations.ApiOperation;


/**
 * 
 * <p>Title: UserController </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午2:20:31
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @param session
	 * @return
	 */
	@ApiOperation(value="获取用户列表", notes="")
	@RequestMapping(value = RestUriConstants.ALL_USERS, method = RequestMethod.GET)
	public Map<String, Object> getAllUsers() {
		Map<String, Object> result = userService.getAllUsers();
		return result;
	}
	
	/**
	 * <p>Title: testException </p>
	 * <p>Description: 测试controller层异常 </p>
	 * @param session
	 * @return
	 */
	@ApiOperation(value="测试controller层异常", notes="")
	@RequestMapping(value = RestUriConstants.TEST_EXCEPTION, method = RequestMethod.GET)
	public Map<String, Object> testException() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("result", 5/0);
		return result;
	}

}
