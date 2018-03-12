package com.springboot.demo.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: Scheduler1TaskTest </p>
 * <p>Description: TODO </p>
 * Date: 2017年12月6日 上午8:59:22
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年12月6日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Scheduler1TaskTest {	
	
	
	@Test
	public void test() throws InterruptedException{
		Thread.sleep(36000);
	}

}
