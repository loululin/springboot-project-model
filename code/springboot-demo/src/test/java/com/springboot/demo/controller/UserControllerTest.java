package com.springboot.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.demo.Application;
import com.springboot.demo.util.RestUriConstants;

/**
 * <p>Title: UserControllerTest </p>
 * <p>Description: TODO </p>
 * Date: 2017年11月23日 下午3:08:42
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年11月23日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
    /**
     * <p>Title: getAllUsersTest </p>
     * <p>Description: 验证controller是否正常响应并打印返回结果 </p>
     * @throws Exception
     */
    @Test
    public void getAllUsersTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(RestUriConstants.ALL_USERS).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
