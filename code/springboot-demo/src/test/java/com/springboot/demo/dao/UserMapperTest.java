package com.springboot.demo.dao;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
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
 * <p>Title: UserMapperTest </p>
 * <p>Description: TODO </p>
 * Date: 2017年11月21日 下午5:19:24
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年11月21日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void getUsers(){
		List<Map<String, Object>> result = userMapper.getUsers();
		logger.info(Constants.COMM_GSON.toJson(result));
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
	}
	
	@Test
	public void performTask(){
        logger.info("This is an {} message.","info");
        logger.warn("This is a warn message.");
        logger.error("This is an error message.");
        logger.debug("This is a debug message.");
    }


}
