package com.springboot.demo.controller.mockito;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.google.common.collect.Maps;
import com.springboot.demo.Application;
import com.springboot.demo.service.UserService;
import com.springboot.demo.util.Constants;
import com.springboot.demo.util.RestUriConstants;

import net.minidev.json.JSONObject;

/**
 * <p>Title: UserControllerTest </p>
 * <p>Description: TODO </p>
 * Date: 2018年2月5日 下午5:16:46
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月5日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {
	/**
	 * Spring Boot class to perform restful operations 
	 */
    @Autowired
    private MockMvc mockMVC;
    
    /**
     * Spring Boot class to perform restful operations
     */
    @MockBean
    UserService userServiceMock;
    
    /**
     * expect values to be returned by the controller 
     */
    private Map<String, Object> expectedUsers;
    
    /**
     * <p>Title: setUp </p>
     * <p>Description: executed before each test case method -> initializes the expected values </p>
     */
    @Before
    public void setUp() {
    	expectedUsers = Maps.newHashMapWithExpectedSize(3);
    	List<Map<String, Object>> userList = new ArrayList<>();
    	Map<String, Object> userTemp;
    	int length = 6;
		for (int i = 1; i < length; i++) {
    		userTemp = Maps.newHashMapWithExpectedSize(3);
    		userTemp.put("name", "name" + i);
    		userTemp.put("age",i);
    		userTemp.put("id",i);
    		userList.add(userTemp);
    	}
    	expectedUsers.put("code", Constants.CODE_SUCCESS);
		expectedUsers.put("msg", Constants.MSG_SUCCESS);
		expectedUsers.put("result", userList);
    }
    
    @Test
    public void getAllUsersWithValidArgumentsShouldReturnAResponseEntityWithMapOfUsersAndHttpStatusOK() throws Exception {
        // you can use in static way or do a static import
        // mocks the DAO behavior to return the expected Users list
        Mockito.doReturn(expectedUsers).when(userServiceMock).getAllUsers();
 
        this.mockMVC.perform(get(RestUriConstants.ALL_USERS))
                .andExpect(status().isOk())
                .andExpect(content().string(new JSONObject(expectedUsers).toJSONString()))
                .andDo(MockMvcResultHandlers.print());
 
        // indicates to Mockito that verifies if the mocked objects were called
        Mockito.verify(userServiceMock).getAllUsers();
    }
}
