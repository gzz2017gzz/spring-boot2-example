package com.gzz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.sys.user.User;
import com.gzz.sys.user.UserCond;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserTests {
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void save() throws Exception {
		User user = User.builder().gender((byte) 1).name("gzz").build();
		// user.setBirthday(null).setGender(null).setId(null).setName(null);
		MvcResult result = mockMvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(user))).andExpect(status().isOk())// 模拟向testRest发送post请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();// 返回执行请求的结果

		log.info(result.getResponse().getContentAsString());
	}

	@Test
	public void queryList() throws Exception {
		UserCond cond = UserCond.builder()//
				.gender((byte) 1)//
				.ids(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 })//
				.build();

		MvcResult result = mockMvc.perform(post("/user/queryList").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(cond))).andExpect(status().isOk())// 模拟向testRest发送post请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();// 返回执行请求的结果

		log.info(result.getResponse().getContentAsString());
	}

	@Test
	public void queryPage() throws Exception {
		UserCond cond = UserCond.builder().gender((byte) 1).build();
		MvcResult result = mockMvc.perform(post("/user/queryPage").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(cond))).andExpect(status().isOk())// 模拟向testRest发送post请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();// 返回执行请求的结果

		log.info(result.getResponse().getContentAsString());
	}
}