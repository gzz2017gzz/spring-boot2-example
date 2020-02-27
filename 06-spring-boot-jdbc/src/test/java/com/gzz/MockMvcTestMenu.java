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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.sys.menu.Menu;
import com.gzz.sys.menu.MenuCond;

import lombok.extern.slf4j.Slf4j;
/**
 * @类说明 [菜单]测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author 高振中
 * @date 2019-01-12 22:40:08
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTestMenu {
 
	@Autowired
	private MockMvc mvc;
	/**
	 * @方法说明 测试 新增[菜单]记录,根据数据类型修改每个字段的值
	 */
 	//@Test
	public void save() throws Exception {
 		Menu menu = Menu.builder()
 		//.id("gaozz") // 设置【主键】的值
 		//.parentId("gaozz") // 设置【上级主键】的值
 		//.level("gaozz") // 设置【层级】的值
 		//.type("gaozz") // 设置【类型】的值
 		//.icon("gaozz") // 设置【图标】的值
 		//.name("gaozz") // 设置【名称】的值
 		//.path("gaozz") // 设置【路径】的值
 		//.orderNum("gaozz") // 设置【排序编号】的值
 		//.remark("gaozz") // 设置【备注】的值
 		.build();
		log.info(doRequest("/menu/save", menu));
	}
	/**
	 * @方法说明 测试 查询[菜单]列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		MenuCond cond = MenuCond.builder()
 		//.id("gaozz")  // 设置查询条件【主键】的值
 		//.parentId("gaozz")  // 设置查询条件【上级主键】的值
 		//.level("gaozz")  // 设置查询条件【层级】的值
 		//.type("gaozz")  // 设置查询条件【类型】的值
 		//.icon("gaozz")  // 设置查询条件【图标】的值
 		//.name("gaozz")  // 设置查询条件【名称】的值
 		//.path("gaozz")  // 设置查询条件【路径】的值
 		//.orderNum("gaozz")  // 设置查询条件【排序编号】的值
 		//.remark("gaozz")  // 设置查询条件【备注】的值
		.build();
		log.info(doRequest("/menu/queryList", cond));
	}
	/**
	 * @方法说明 测试 查询[菜单]分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		MenuCond cond = MenuCond.builder()
 		//.id("gaozz")  // 设置查询条件【主键】的值
 		//.parentId("gaozz")  // 设置查询条件【上级主键】的值
 		//.level("gaozz")  // 设置查询条件【层级】的值
 		//.type("gaozz")  // 设置查询条件【类型】的值
 		//.icon("gaozz")  // 设置查询条件【图标】的值
 		//.name("gaozz")  // 设置查询条件【名称】的值
 		//.path("gaozz")  // 设置查询条件【路径】的值
 		//.orderNum("gaozz")  // 设置查询条件【排序编号】的值
 		//.remark("gaozz")  // 设置查询条件【备注】的值
		.build();
		cond.setPage(0); //当前页
		cond.setSize(10); //页大小
		log.info(doRequest("/menu/queryPage", cond));
	}
	
	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}