package com.springboot.demo.service;

import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.demo.util.Constants;

/**
 * <p>Title: UserServiceTest </p>
 * <p>Description: TODO </p>
 * Date: 2017年11月23日 下午3:00:23
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年11月23日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getAllUsersTest(){
		Map<String, Object> response = userService.getAllUsers();
		logger.info("userService.getAllUsers() is : " + Constants.COMM_GSON.toJson(response));
		
		Map<String, Object> response1 = userService.getAllUsers();
		logger.info("userService.getAllUsers() is : " + Constants.COMM_GSON.toJson(response1));
		Map<String, Object> response2 = userService.getAllUsers();
		logger.info("userService.getAllUsers() is : " + Constants.COMM_GSON.toJson(response2));
		Assert.assertThat(response.get("msg"), equalTo(Constants.MSG_SUCCESS));
	}
	
	@Test
	public void getUsersByPage(){
		Map<String, Object> response = userService.getUsersByPage();
		logger.info("userService.getAllUsers() is : " + Constants.COMM_GSON.toJson(response));
	}
	
	
}
