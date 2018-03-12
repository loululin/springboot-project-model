package com.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>Title: Application </p>
 * <p>Description: TODO </p>
 * Date: 2017年11月21日 下午5:17:02
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年11月21日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan("com.springboot.demo.dao")
public class Application extends SpringBootServletInitializer {
	
	

    /** 
     * (non-Javadoc)
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}

	/** 
	 * <p>Title: main </p>
	 * <p>Description: TODO </p>
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
