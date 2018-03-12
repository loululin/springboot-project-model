package com.springboot.demo.okhttp3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: LdrkZhuYeSubMapperTest </p>
 * <p>Description: TODO </p>
 * Date: 2016年8月15日 上午11:18:42
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年8月15日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OkhttpTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(OkhttpTest.class);

	@Test
	public void getTest(){
		String get = OkHttpUtil.getStringFromServer("https://www.baidu.com/");
		LOGGER.info("get baidu is "  + get);
	}
	
	

}
