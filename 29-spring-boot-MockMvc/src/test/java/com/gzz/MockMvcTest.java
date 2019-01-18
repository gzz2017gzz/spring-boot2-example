package com.gzz;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.controller.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {

	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MockMvc mvc;

//	@Test
	public void getHello() throws Exception {// 查看控制台
		MvcResult result = mvc.perform(get("/hello")).andExpect(status().isOk()).andReturn();
		logger.info(result.getResponse().getContentAsString());
	}

//	@Test
	public void getHello2() throws Exception {// 通过断言看是否出异常
		mvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("hello")));
	}
// 	@Test
	public void save() throws Exception {// 查看控制台
		MvcResult result = mvc.perform(get("/save").param("id", "123"))
				.andExpect(status().isOk())
				.andReturn();
		logger.info(result.getResponse().getContentAsString());
	}
// 	@Test
 	public void update() throws Exception {// 查看控制台
 		MvcResult result = mvc.perform(get("/update").param("id", "123").param("name", "gzz").param("gender", "1"))
 				.andExpect(status().isOk())
 				.andReturn();
 		logger.info(result.getResponse().getContentAsString());
 	}
 

//    @Test
	public void getHello1() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

//	@Test
	public void insert() throws Exception {
		User user = new  User ();
		user.setBirthday(new Date());
		user.setId(123);
		user.setGender((byte)1);
		user.setName("刘德华");
		MvcResult result = mvc.perform(post("/insert")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(user))).andExpect(status().isOk()) 
 				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
				.andReturn(); 

		logger.info(result.getResponse().getContentAsString());
	}
	@Test
	public void select() throws Exception {
		User user = new  User ();
		user.setBirthday(new Date());
		user.setId(123);
		user.setGender((byte)1);
		user.setName("刘德华");
		MvcResult result = mvc.perform(post("/select")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(user))).andExpect(status().isOk()) 
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
				.andReturn();// 返回执行请求的结果
		
		logger.info(result.getResponse().getContentAsString());
	}
}