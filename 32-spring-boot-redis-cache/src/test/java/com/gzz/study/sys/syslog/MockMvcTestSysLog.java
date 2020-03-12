package com.gzz.study.sys.syslog;

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
 * @类说明 【请求日志】测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author 高振中
 * @date 2019-01-12 22:40:08
 **/
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MockMvcTestSysLog {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	/**
	 * @方法说明 测试 新增【请求日志】记录,根据数据类型修改每个字段的值
	 */
 	//@Test
	public void save() throws Exception {
 		SysLog sysLog = SysLog.builder()
 		//.id("gaozz") // 设置【主键】的值
 		//.client_ip("gaozz") // 设置【客户端IP】的值
 		//.uri("gaozz") // 设置【请求地址】的值
 		//.type("gaozz") // 设置【请求方式,普通,ajax】的值
 		//.method("gaozz") // 设置【method post get等】的值
 		//.param_data("gaozz") // 设置【参数json】的值
 		//.session_id("gaozz") // 设置【sessionID】的值
 		//.request_time("gaozz") // 设置【request_time】的值
 		//.return_time("gaozz") // 设置【return_time】的值
 		//.return_data("gaozz") // 设置【返回json】的值
 		//.status_code("gaozz") // 设置【httpStatusCode】的值
 		//.cost_time("gaozz") // 设置【耗时-毫秒）】的值
 		.build();
		log.info(doRequest("/sysLog/save", sysLog));
	}
	/**
	 * @方法说明 测试 查询【请求日志】列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		SysLogCond cond = SysLogCond.builder()//拼查询条件
 				//.id("gaozz")  // 【主键】值
 				//.client_ip("gaozz")  // 【客户端IP】值
 				//.uri("gaozz")  // 【请求地址】值
 				//.type("gaozz")  // 【请求方式,普通,ajax】值
 				//.method("gaozz")  // 【method post get等】值
 				//.param_data("gaozz")  // 【参数json】值
 				//.session_id("gaozz")  // 【sessionID】值
 				//.request_time("gaozz")  // 【request_time】值
 				//.return_time("gaozz")  // 【return_time】值
 				//.return_data("gaozz")  // 【返回json】值
 				//.status_code("gaozz")  // 【httpStatusCode】值
 				//.cost_time("gaozz")  // 【耗时-毫秒）】值
		.build();
		log.info(doRequest("/sysLog/list", cond));
	}
	/**
	 * @方法说明 测试 查询【请求日志】分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		SysLogCond cond = SysLogCond.builder()//拼查询条件
 				//.id("gaozz")  // 【主键】值
 				//.client_ip("gaozz")  // 【客户端IP】值
 				//.uri("gaozz")  // 【请求地址】值
 				//.type("gaozz")  // 【请求方式,普通,ajax】值
 				//.method("gaozz")  // 【method post get等】值
 				//.param_data("gaozz")  // 【参数json】值
 				//.session_id("gaozz")  // 【sessionID】值
 				//.request_time("gaozz")  // 【request_time】值
 				//.return_time("gaozz")  // 【return_time】值
 				//.return_data("gaozz")  // 【返回json】值
 				//.status_code("gaozz")  // 【httpStatusCode】值
 				//.cost_time("gaozz")  // 【耗时-毫秒）】值
 		.ids(Arrays.asList(new Object[]{1,2,3,4}))
		.build();
		cond.setPage(0); //当前页
		cond.setSize(10); //页大小
		log.info(doRequest("/sysLog/page", cond));
	}
	
	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}