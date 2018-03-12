package com.springboot.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Maps;
import com.springboot.demo.util.Constants;

/**
 * <p>Title: UserMapperTestMock </p>
 * <p>Description: TODO </p>
 * Date: 2017年10月13日 下午1:49:06
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年10月13日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockUserMapperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MockUserMapperTest.class);

	private UserMapper userMapper;
	
	/**
	 * <p>Title: before </p>
	 * <p>Description: 初始化方法 </p>
	 */
	@Before
	public void before(){
		userMapper = EasyMock.createMock(UserMapper.class);
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user1 = Maps.newHashMapWithExpectedSize(2);
		user1.put("name", "leilei");
		user1.put("age", 20);
		users.add(user1);
		Map<String, Object> user2 = Maps.newHashMapWithExpectedSize(2);
		user2.put("name", "huihui");
		user2.put("age", 30);
		users.add(user2);
		Map<String, Object> user3 = Maps.newHashMapWithExpectedSize(2);
		user3.put("name", "lili");
		user3.put("age", 30);
		users.add(user3);
		//录制Mock对象预期行为，andReturn方法表示返回的预期结果
		EasyMock.expect(userMapper.getUsers()).andReturn(users); 
		//重放Mock对象，测试时以录制的对象预期行为代替真实对象的行为 
		EasyMock.replay(userMapper);
		
	}
	
	@Test
	public void getUsersTest(){
		List<Map<String, Object>> result = userMapper.getUsers();
		LOGGER.info("gettroopsId IS :   ---"  + Constants.COMM_GSON.toJson(result));
		//左边实际值，右边括号里面是期望值
		Assert.assertThat(result.size(), Matchers.equalTo(3));
	}
	
	@After
	public void after(){
		System.out.println("测试完之后释放资源");
	}

}
