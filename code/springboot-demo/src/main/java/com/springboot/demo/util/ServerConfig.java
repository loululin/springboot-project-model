package com.springboot.demo.util;

import java.util.List;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;

/**
 * <p>Title: ServerConfig </p>
 * <p>Description: 系统配置 </p>
 * Date: 2016年11月14日 上午10:03:12
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年11月14日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@HotReload
@Sources({ "classpath:ServerConfig.properties" })
public interface ServerConfig extends Config {
	
	/**
	 * <p>Title: getIntDemo </p>
	 * <p>Description: 获取int型值 </p>
	 * @return
	 */
	@Key("int.demo")
	int getIntDemo();

	/**
	 * <p>Title: getZhucheng </p>
	 * <p>Description: 获取List<String>型值 </p>
	 * @return
	 */
	@Key("zhucheng")
	List<String> getZhucheng();

	/**
	 * <p>Title: getHelloMr </p>
	 * <p>Description: 获取带参数的string值  </p>
	 * @param mr
	 * @return
	 */
	@Key("helloMr")
	String getHelloMr(String mr);

	/**
	 * <p>Title: getFruit </p>
	 * <p>Description: 获取String[]型值 </p>
	 * @return
	 */
	@Key("fruit")
	public String[] getFruit();
	
	/**
	 * <p>Title: getFibonacci </p>
	 * <p>Description: 获取指定分隔符号的int[]型值  </p>
	 * @return
	 */
	@Separator(";")
	@Key("fibonacci")
	public int[] getFibonacci();
}
