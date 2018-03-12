package com.springboot.demo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>Title: CacheConfiguration </p>
 * <p>Description: 启动缓存 </p>
 * Date: 2018年1月31日 上午10:54:02
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年1月31日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

	/**
	 *  ehcache 主要的管理器
	 * @param bean
	 * @return
	 */
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		return new EhCacheCacheManager(bean.getObject());
	}

	/**
	 * 据shared与否的设置, Spring分别通过CacheManager.create() 或new CacheManager()方式来创建一个ehcache基地.
	 * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}

}
