package com.gzz;

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
import com.gzz.sys.customer.Customer;
import com.gzz.sys.customer.CustomerCond;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 【客户】测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author 高振中
 * @date 2019-01-12 22:40:08
 **/
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MockMvcTestCustomer {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	/**
	 * @方法说明 测试 新增【客户】记录,根据数据类型修改每个字段的值
	 */
	// @Test
	public void save() throws Exception {
		Customer customer = Customer.builder()
				// .id("gaozz") // 设置【主键】的值
				// .name("gaozz") // 设置【客户名称】的值
				// .tradeType("gaozz") // 设置【行业类型 化工0配电1变电 2】的值
				// .title("gaozz") // 设置【系统标题】的值
				// .address("gaozz") // 设置【地址】的值
				// .url("gaozz") // 设置【公司网址】的值
				// .contacts("gaozz") // 设置【联系人】的值
				// .contactsJob("gaozz") // 设置【联系人职位】的值
				// .contactsTel("gaozz") // 设置【联系人电话】的值
				// .contactsMail("gaozz") // 设置【联系人邮件】的值
				// .contactsOther("gaozz") // 设置【联系人邮件】的值
				// .phoneNo("gaozz") // 设置【联系方式】的值
				// .remark("gaozz") // 设置【备注】的值
				.build();
		log.info(doRequest("/customer/save", customer));
	}

	/**
	 * @方法说明 测试 查询【客户】列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		CustomerCond cond = CustomerCond.builder()
				// .id("gaozz") // 设置查询条件【主键】的值
				// .name("gaozz") // 设置查询条件【客户名称】的值
				// .tradeType("gaozz") // 设置查询条件【行业类型 化工0配电1变电 2】的值
				// .title("gaozz") // 设置查询条件【系统标题】的值
				// .address("gaozz") // 设置查询条件【地址】的值
				// .url("gaozz") // 设置查询条件【公司网址】的值
				// .contacts("gaozz") // 设置查询条件【联系人】的值
				// .contactsJob("gaozz") // 设置查询条件【联系人职位】的值
				// .contactsTel("gaozz") // 设置查询条件【联系人电话】的值
				// .contactsMail("gaozz") // 设置查询条件【联系人邮件】的值
				// .contactsOther("gaozz") // 设置查询条件【联系人邮件】的值
				// .phoneNo("gaozz") // 设置查询条件【联系方式】的值
				// .remark("gaozz") // 设置查询条件【备注】的值
				.build();
		log.info(doRequest("/customer/list", cond));
	}

	/**
	 * @方法说明 测试 查询【客户】分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		CustomerCond cond = CustomerCond.builder()
				.id(1) // 设置查询条件【主键】的值
				.name("gaozz") // 设置查询条件【客户名称】的值
				.tradeType((byte) 1) // 设置查询条件【行业类型 化工0配电1变电 2】的值
				.title("gaozz") // 设置查询条件【系统标题】的值
				.ids(Arrays.asList(new Object[]{1,2,3,4}))
				.address("gaozz") // 设置查询条件【地址】的值
				.url("gaozz") // 设置查询条件【公司网址】的值
				.contacts("gaozz") // 设置查询条件【联系人】的值
				.contactsJob("gaozz") // 设置查询条件【联系人职位】的值
				.contactsTel("gaozz") // 设置查询条件【联系人电话】的值
				.contactsMail("gaozz") // 设置查询条件【联系人邮件】的值
				.contactsOther("gaozz") // 设置查询条件【联系人邮件】的值
				.phoneNo("gaozz") // 设置查询条件【联系方式】的值
				.remark("gaozz") // 设置查询条件【备注】的值
				.build();
		cond.setPage(0); // 当前页
		cond.setSize(10); // 页大小
		log.info(doRequest("/customer/page", cond));
	}

	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
	}
}