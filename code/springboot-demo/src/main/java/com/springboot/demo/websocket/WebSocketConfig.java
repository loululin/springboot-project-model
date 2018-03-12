package com.springboot.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * <p>Title: WebSocketConfig </p>
 * <p>Description: TODO </p>
 * Date: 2017年12月18日 下午1:32:45
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年12月18日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	

	/**
	 * (non-Javadoc)
	 * @see org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer#configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry)
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer#registerStompEndpoints(org.springframework.web.socket.config.annotation.StompEndpointRegistry)
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
	}

}
