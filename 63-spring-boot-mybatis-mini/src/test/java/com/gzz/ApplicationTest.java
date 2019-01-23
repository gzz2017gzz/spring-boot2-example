package com.gzz;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
	@Autowired
	private MockMvc mvc;
	private static final Log logger = LogFactory.getLog(ApplicationTest.class);
	private ObjectMapper mapper = new ObjectMapper();

//	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World!"))).andDo(print()).andReturn();
	}

//	@Test
	public void getHello1() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		logger.info(result.getResponse().getContentAsString());
	}
	@Test
	public void save() throws Exception {
		User user = new User();
		user.setName("gzz");
		user.setAge(30);
		MvcResult result = mvc
				.perform(post("/test/add").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(user)))
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andReturn();// 返回执行请求的结果

		logger.info(result.getResponse().getContentAsString());
	}
}
