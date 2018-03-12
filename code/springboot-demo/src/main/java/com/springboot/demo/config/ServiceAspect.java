package com.springboot.demo.config;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

/**
 * <p>Title: ServiceAspect </p>
 * <p>Description: TODO </p>
 * Date: 2018年2月7日 上午10:40:37
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月7日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Component
@Aspect
public class ServiceAspect {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);
	
	
	@Around("execution(* com.springboot.demo.service.*.*(..))")
    public Object handleServiceMethod(ProceedingJoinPoint pjp) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object result = null;
        try {
        	LOGGER.info("执行Service开始: " + pjp.getSignature() + " 参数：" + Lists.newArrayList(pjp.getArgs()).toString());
            result = pjp.proceed(pjp.getArgs());
            LOGGER.info("执行Service结束: " + pjp.getSignature() + "， 返回值：" + result.toString());
            LOGGER.info("耗时：" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS) + "(毫秒).");
        } catch (Throwable e) {
            if (e instanceof RuntimeException) {
            	LOGGER.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            } else {
            	LOGGER.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            }
        }
        return result;
    }

}
