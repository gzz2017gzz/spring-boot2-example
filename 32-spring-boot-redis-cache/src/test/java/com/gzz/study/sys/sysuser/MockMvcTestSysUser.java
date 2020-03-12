package com.gzz.study.sys.sysuser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
/**
 * @类说明 【用户】测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author 高振中
 * @date 2019-01-12 22:40:08
 **/
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MockMvcTestSysUser {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	/**
	 * @方法说明 测试 新增【用户】记录,根据数据类型修改每个字段的值
	 */
 	//@Test
	public void save() throws Exception {
 		SysUser sysUser = SysUser.builder()
 		//.id("gaozz") // 设置【主键】的值
 		//.name("gaozz") // 设置【姓名】的值
 		//.birthday("gaozz") // 设置【生日】的值
 		//.gender("gaozz") // 设置【性别】的值
 		.build();
		log.info(doRequest("/sysUser/save", sysUser));
	}
	/**
	 * @方法说明 测试 查询【用户】列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		SysUserCond cond = SysUserCond.builder()//拼查询条件
 				//.id("gaozz")  // 【主键】值
 				//.name("gaozz")  // 【姓名】值
 				//.birthday("gaozz")  // 【生日】值
 				//.gender("gaozz")  // 【性别】值
				.ids(Arrays.asList(new Object[]{1,2,3,4}))
		.build();
		log.info(doRequest("/sysUser/list", cond));
	}
	/**
	 * @方法说明 测试 查询【用户】分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		SysUserCond cond = SysUserCond.builder()//拼查询条件
 				//.id("gaozz")  // 【主键】值
 				//.name("gaozz")  // 【姓名】值
 				//.birthday("gaozz")  // 【生日】值
 				//.gender("gaozz")  // 【性别】值
 		.ids(Arrays.asList(new Object[]{1,2,3,4}))
		.build();
		cond.setPage(0); //当前页
		cond.setSize(10); //页大小
		log.info(doRequest("/sysUser/page", cond));
	}
	
	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}