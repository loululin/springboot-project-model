package com.springboot.demo.exception;

/**
 * <p>Title: CommException </p>
 * <p>Description: 项目公用异常 </p>
 * Date: 2018年2月7日 上午10:01:39
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月7日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class CommException extends RuntimeException {

	/**
	 * Fields serialVersionUID: TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
    private String msg;
	/**
	 * <p>Title: CommException </p>
	 * <p>Description: Constructor </p> 
	 * @param code
	 * @param msg 
	 */
	public CommException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	/**
	 * CommException.java
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * CommException.java
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * CommException.java
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * CommException.java
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
