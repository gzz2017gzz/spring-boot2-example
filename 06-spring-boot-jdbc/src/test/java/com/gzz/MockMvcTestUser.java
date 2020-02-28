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

//import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.sys.user.User;
import com.gzz.sys.user.UserCond;

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
public class MockMvcTestUser {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	/**
	 * @方法说明 测试 新增【用户】记录,根据数据类型修改每个字段的值
	 */
 	//@Test
	public void save() throws Exception {
 		User user = User.builder()
 		//.id("gaozz") // 设置【主键】的值
 		//.customerId("gaozz") // 设置【客户主键】的值
 		//.name("gaozz") // 设置【用户名】的值
 		//.loginName("gaozz") // 设置【登录名】的值
 		//.password("gaozz") // 设置【密码】的值
 		//.email("gaozz") // 设置【邮箱】的值
 		//.phoneNo("gaozz") // 设置【手机号】的值
 		//.status("gaozz") // 设置【1启用0禁用】的值
 		//.createTime("gaozz") // 设置【创建时间】的值
 		//.type("gaozz") // 设置【1内置2普通】的值
 		//.updateTime("gaozz") // 设置【修改时间】的值
 		//.remark("gaozz") // 设置【备注】的值
 		.build();
		log.info(doRequest("/user/save", user));
	}
	/**
	 * @方法说明 测试 查询【用户】列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		UserCond cond = UserCond.builder()
 		//.id("gaozz")  // 设置查询条件【主键】的值
 		//.customerId("gaozz")  // 设置查询条件【客户主键】的值
 		//.name("gaozz")  // 设置查询条件【用户名】的值
 		//.loginName("gaozz")  // 设置查询条件【登录名】的值
 		//.password("gaozz")  // 设置查询条件【密码】的值
 		//.email("gaozz")  // 设置查询条件【邮箱】的值
 		//.phoneNo("gaozz")  // 设置查询条件【手机号】的值
 		//.status("gaozz")  // 设置查询条件【1启用0禁用】的值
 		//.createTime("gaozz")  // 设置查询条件【创建时间】的值
 		//.type("gaozz")  // 设置查询条件【1内置2普通】的值
 		//.updateTime("gaozz")  // 设置查询条件【修改时间】的值
 		//.remark("gaozz")  // 设置查询条件【备注】的值
		.build();
		log.info(doRequest("/user/queryList", cond));
	}
	/**
	 * @方法说明 测试 查询【用户】分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		UserCond cond = UserCond.builder()
 		//.id("gaozz")  // 设置查询条件【主键】的值
 		//.customerId("gaozz")  // 设置查询条件【客户主键】的值
 		//.name("gaozz")  // 设置查询条件【用户名】的值
 		//.loginName("gaozz")  // 设置查询条件【登录名】的值
 		//.password("gaozz")  // 设置查询条件【密码】的值
 		//.email("gaozz")  // 设置查询条件【邮箱】的值
 		//.phoneNo("gaozz")  // 设置查询条件【手机号】的值
 		//.status("gaozz")  // 设置查询条件【1启用0禁用】的值
 		//.createTime("gaozz")  // 设置查询条件【创建时间】的值
 		//.type("gaozz")  // 设置查询条件【1内置2普通】的值
 		//.updateTime("gaozz")  // 设置查询条件【修改时间】的值
 		//.remark("gaozz")  // 设置查询条件【备注】的值
		.build();
		cond.setPage(0); //当前页
		cond.setSize(10); //页大小
		log.info(doRequest("/user/queryPage", cond));
	}
	
	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}