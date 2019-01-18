package com.gzz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzz.user.UserDao;
import com.gzz.user.model.UserCond;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestSource {
	private static final Log logger = LogFactory.getLog(TestSource.class);// 日志类

	@Autowired
	private UserDao dao;

	@Test
	public void test() {
		logger.info(dao.queryDs1(new UserCond()));
		logger.info(dao.queryDs2(new UserCond()));
	}
}
