package com.springboot.demo.service.easymock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.google.common.collect.Maps;
import com.springboot.demo.dao.UserMapper;
import com.springboot.demo.service.UserService;
import com.springboot.demo.util.Constants;

/**
 * <p>Title: UserServiceTest </p>
 * <p>Description: TODO </p>
 * Date: 2018年2月5日 下午6:16:41
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月5日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(EasyMockRunner.class)
public class UserServiceTest {
	/**
	 * instantiates the subject of test and injects the mocked dependencies 
	 */
    @TestSubject
    UserService userService = new UserService();
     
    /**
     * mock the autowired dependency of the test subject 
     */
    @Mock
    UserMapper userMapperMock;
 
    /**
     * used to assert and catch the expected exceptions thrown by the test subject 
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
     
    /**
     * expect values to be returned by the service 
     */
    private Map<String,Object> expectedUsers;
    /**
     * expect values to be returned by the dao 
     */
    private List<Map<String, Object>> userList;
    
    /**
     * <p>Title: setUp </p>
     * <p>Description: executed before each test case method -> initializes the expected values </p>
     */
    @Before
    public void setUp() {
    	expectedUsers = Maps.newHashMapWithExpectedSize(3);
    	userList = new ArrayList<>();
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
    public void getAllUsersWithValidArgumentsShouldReturnAMapWithAllUsers() throws Exception {
        // you can use in static way or do a static import
        // mocks the expected behavior for the DAO in this test case
        // important: you will test only the logic and the coverage of the test subject so mock the dependecies for that
        EasyMock.expect(userMapperMock.getUsers()).andReturn(userList);
        // indicates to EasyMock that has to "record" the expected behavior of mock objects
        EasyMock.replay(userMapperMock);
         
        // invokes the test subject that uses the mocked behaviors      
        Map<String,Object> result = userService.getAllUsers();
         
        // assert the expected results of the test case
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(expectedUsers.size()));
        assertThat(result.get("code"), equalTo(expectedUsers.get("code")));
        assertThat(result.get("msg"), equalTo(expectedUsers.get("msg")));
        assertThat(result.get("result"), equalTo(expectedUsers.get("result")));
         
        // indicates to EasyMock that verifies if the mocked objects were called
        EasyMock.verify(userMapperMock);
    }
}
