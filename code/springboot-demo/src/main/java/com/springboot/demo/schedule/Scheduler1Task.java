package com.springboot.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hiynn.util.time.normal.NormalTime;

/**
 * <p>Title: Scheduler1Task </p>
 * <p>Description: TODO </p>
 * Date: 2017年12月6日 上午8:57:50
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年12月6日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Component
public class Scheduler1Task {
	private int count=0;
	
    @Scheduled(cron="0 10 * * * ?")
    private void process(){
        System.out.println("time: " + NormalTime.getCurrentTime("yyyy-MM-dd hh:mm:ss")+ "this is scheduler task runing  "+(count++));
    }
}
