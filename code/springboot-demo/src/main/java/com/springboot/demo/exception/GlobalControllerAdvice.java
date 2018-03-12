package com.springboot.demo.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.demo.util.Constants;

/**
 * <p>Title: GlobalControllerAdvice </p>
 * <p>Description: TODO </p>
 * Date: 2018年2月7日 上午9:33:54
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月7日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RestControllerAdvice
public class GlobalControllerAdvice {
	
	/**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception ex) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", Constants.CODE_FALSE);
        map.put("msg", Constants.MSG_FALSE);
        map.put("result", ex.getMessage());
        return map;
    }
    
    /**
     * 自定义异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CommException.class)
    public Map<String, Object> commErrorHandler(Exception ex) {
    	Map<String, Object> map = new LinkedHashMap<>();
    	map.put("code", Constants.CODE_FALSE);
    	map.put("msg", Constants.MSG_FALSE);
    	map.put("result", ex.getMessage());
    	return map;
    }

}
