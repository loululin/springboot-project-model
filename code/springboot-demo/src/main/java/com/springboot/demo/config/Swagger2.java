package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title: Swagger2 </p>
 * <p>Description: TODO </p>
 * Date: 2018年1月31日 下午5:23:02
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
@EnableSwagger2
public class Swagger2 {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    			 .title("springboot-demo project RESTful APIs")
    			 .description("project api document")
    			 .contact(new Contact("loulvlin", "", "loulvlin@hiynn.com"))
    			 .termsOfServiceUrl("http://localhost:8080/springboot-demo/doc.html")
    			 .version("1.0")
    			 .build();
    }
}
