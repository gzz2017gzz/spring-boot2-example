package com.gzz.sysuser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @类说明 [请求日志]测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTestSysUser {
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MockMvc mvc;

	/**
	 * @方法说明 测试 新增[用户]记录,根据数据类型修改每个字段的值
	 */
	// @Test
	public void save() throws Exception {
		SysUser sysUser = SysUser.builder()
				// .id("http://www.gaozz.club") // 设置【主键】的值
				// .name("http://www.gaozz.club") // 设置【姓名】的值
				// .birthday("http://www.gaozz.club") // 设置【生日】的值
				// .gender("http://www.gaozz.club") // 设置【性别】的值
				.build();
		logger.info(doRequest("/sysUser/save", sysUser));
	}

	/**
	 * @方法说明 测试 查询[用户]列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		SysUserCond cond = SysUserCond.builder()
				// .id("http://www.gaozz.club") // 设置查询条件【主键】的值
				// .name("http://www.gaozz.club") // 设置查询条件【姓名】的值
				// .birthday("http://www.gaozz.club") // 设置查询条件【生日】的值
				// .gender("http://www.gaozz.club") // 设置查询条件【性别】的值
				.build();
		logger.info(doRequest("/sysUser/queryList", cond));// 返回执行请求的结果
	}

	/**
	 * @方法说明 测试 查询[用户]分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		SysUserCond cond = SysUserCond.builder()
				// .id("http://www.gaozz.club") // 设置查询条件【主键】的值
				// .name("http://www.gaozz.club") // 设置查询条件【姓名】的值
				// .birthday("http://www.gaozz.club") // 设置查询条件【生日】的值
				// .gender("http://www.gaozz.club") // 设置查询条件【性别】的值
				.build();
		//cond.setPage(0);//当前页
		//cond.setSize(10);//页大小
		
		logger.info(doRequest("/sysUser/queryPage", cond));// 返回执行请求的结果
	}

	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}