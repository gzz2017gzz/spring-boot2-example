package com.gzz.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzz.Application;
import com.gzz.user.model.UserCond;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
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
