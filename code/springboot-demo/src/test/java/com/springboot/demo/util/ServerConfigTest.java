package com.springboot.demo.util;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * <p>Title: ServerConfigTest </p>
 * <p>Description: TODO </p>
 * Date: 2018年2月5日 上午11:26:58
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月5日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerConfigTest {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerConfigTest.class);
	
	@Test
	public void getIntDemoTest(){
		int intDemo = ServerConfigUtil.getServerConf().getIntDemo();
		
		LOGGER.info("intDemo is "  + intDemo);
		Assert.assertThat(intDemo, Matchers.equalTo(10));
	}
	
	@Test
	public void getZhuchengTest(){
		List<String> result  = ServerConfigUtil.getServerConf().getZhucheng();
		
		LOGGER.info("getZhuchengTest is "  + result);
		Assert.assertThat(result.size(), Matchers.equalTo(11));
	}
	
	@Test
	public void getHelloMrTest(){
		String result  = ServerConfigUtil.getServerConf().getHelloMr("leilei");
		
		LOGGER.info("getHelloMrTest is "  + result);
		Assert.assertThat(result, Matchers.equalTo("Hello , leilei!"));
	}
	
	@Test
	public void getFruitTest(){
		String[] result  = ServerConfigUtil.getServerConf().getFruit();
		
		LOGGER.info("getFruitTest is "  + Constants.COMM_GSON.toJson(result));
		Assert.assertThat(result[0], Matchers.equalTo("apple"));
	}
	
	@Test
	public void getFibonacciTest(){
		int[] result  = ServerConfigUtil.getServerConf().getFibonacci();
		
		LOGGER.info("getFibonacci is "  + Constants.COMM_GSON.toJson(result));
		Assert.assertThat(result[0], Matchers.equalTo(0));
	}
	
	
	
	
	
	

}
