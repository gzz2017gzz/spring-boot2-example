package com.gzz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {// 查看控制台
		MvcResult result = mvc.perform(get("/push").param("number", "100")).andExpect(status().isOk()).andReturn();
		logger.info(result.getResponse().getContentAsString());
	}

}