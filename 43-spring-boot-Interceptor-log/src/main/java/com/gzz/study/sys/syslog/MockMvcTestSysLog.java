package com.gzz.study.sys.syslog;

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
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @类说明 [请求日志]测试工具，请本类移到maven测试目录中或测试完成之后删除
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTestSysLog {
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MockMvc mvc;
	/**
	 * @方法说明 测试 新增[请求日志]记录,根据数据类型修改每个字段的值
	 */
 	@Test
	public void save() throws Exception {
 		SysLog sysLog = SysLog.builder()
 		//.id("http://www.gaozz.club/") // 设置【主键】的值
 		//.client_ip("http://www.gaozz.club/") // 设置【客户端IP】的值
 		//.uri("http://www.gaozz.club/") // 设置【请求地址】的值
 		//.type("http://www.gaozz.club/") // 设置【请求方式,普通,ajax】的值
 		//.method("http://www.gaozz.club/") // 设置【method post get等】的值
 		//.param_data("http://www.gaozz.club/") // 设置【参数json】的值
 		//.session_id("http://www.gaozz.club/") // 设置【sessionID】的值
 		//.request_time("http://www.gaozz.club/") // 设置【request_time】的值
 		// .return_time("http://www.gaozz.club/") // 设置【return_time】的值
 		//.return_data("http://www.gaozz.club/") // 设置【返回json】的值
 		//.status_code("http://www.gaozz.club/") // 设置【httpStatusCode】的值
 		//.cost_time("http://www.gaozz.club/") // 设置【耗时-毫秒）】的值
 		.build();
 
		MvcResult result = mvc.perform(post("/sysLog/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(sysLog))).andExpect(status().isOk()) 
 				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
				.andReturn(); 
		logger.info(result.getResponse().getContentAsString());
	}
	/**
	 * @方法说明 测试 查询[请求日志]列表,条件可以为空
	 */
	@Test
	public void queryList() throws Exception {
		SysLogCond cond = SysLogCond.builder()
 		//.id("http://www.gaozz.club/")  // 设置查询条件【主键】的值
 		//.client_ip("http://www.gaozz.club/")  // 设置查询条件【客户端IP】的值
 		//.uri("http://www.gaozz.club/")  // 设置查询条件【请求地址】的值
 		//.type("http://www.gaozz.club/")  // 设置查询条件【请求方式,普通,ajax】的值
 		//.method("http://www.gaozz.club/")  // 设置查询条件【method post get等】的值
 		//.param_data("http://www.gaozz.club/")  // 设置查询条件【参数json】的值
 		//.session_id("http://www.gaozz.club/")  // 设置查询条件【sessionID】的值
 		//.request_time("http://www.gaozz.club/")  // 设置查询条件【request_time】的值
 		//.return_time("http://www.gaozz.club/")  // 设置查询条件【return_time】的值
 		//.return_data("http://www.gaozz.club/")  // 设置查询条件【返回json】的值
 		//.status_code("http://www.gaozz.club/")  // 设置查询条件【httpStatusCode】的值
 		//.cost_time("http://www.gaozz.club/")  // 设置查询条件【耗时-毫秒）】的值
		.build();
		MvcResult result = mvc.perform(post("/sysLog/queryList")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cond))).andExpect(status().isOk()) 
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
				.andReturn();// 返回执行请求的结果
		logger.info(result.getResponse().getContentAsString());
	}
	/**
	 * @方法说明 测试 查询[请求日志]分页列表,条件可以为空
	 */
	@Test
	public void queryPage() throws Exception {
		SysLogCond cond = SysLogCond.builder()
 		//.id("http://www.gaozz.club/")  // 设置查询条件【主键】的值
 		//.client_ip("http://www.gaozz.club/")  // 设置查询条件【客户端IP】的值
 		//.uri("http://www.gaozz.club/")  // 设置查询条件【请求地址】的值
 		//.type("http://www.gaozz.club/")  // 设置查询条件【请求方式,普通,ajax】的值
 		//.method("http://www.gaozz.club/")  // 设置查询条件【method post get等】的值
 		//.param_data("http://www.gaozz.club/")  // 设置查询条件【参数json】的值
 		//.session_id("http://www.gaozz.club/")  // 设置查询条件【sessionID】的值
 		//.request_time("http://www.gaozz.club/")  // 设置查询条件【request_time】的值
 		//.return_time("http://www.gaozz.club/")  // 设置查询条件【return_time】的值
 		//.return_data("http://www.gaozz.club/")  // 设置查询条件【返回json】的值
 		//.status_code("http://www.gaozz.club/")  // 设置查询条件【httpStatusCode】的值
 		//.cost_time("http://www.gaozz.club/")  // 设置查询条件【耗时-毫秒）】的值
		.build();
		MvcResult result = mvc.perform(post("/sysLog/queryPage")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cond))).andExpect(status().isOk()) 
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
				.andReturn();// 返回执行请求的结果
		logger.info(result.getResponse().getContentAsString());
	}
}