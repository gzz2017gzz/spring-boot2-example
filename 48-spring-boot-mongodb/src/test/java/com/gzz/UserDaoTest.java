package com.gzz;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzz.DemoApplication;
import com.gzz.dao.UserDao;
import com.gzz.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserDaoTest {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() {
		// userRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		// 创建10个User，并验证User总数
		userDao.save(new User(1L, "didi", 30));
		userDao.save(new User(2L, "mama", 40));
		userDao.save(new User(3L, "kaka", 50));
		userDao.save(new User(4L, "didi2", 30));
		userDao.save(new User(5L, "mama", 40));
		userDao.save(new User(6L, "kaka2", 50));
		userDao.save(new User(7L, "kaka", 50));
		userDao.save(new User(8L, "kao", 50));
		userDao.save(new User(9L, "ekakae", 50));
		userDao.save(new User(10L, "kaka5", 50));
		userDao.save(new User(11L, "", 50));
		userDao.save(new User(12L, null, 50));
		this.logger.info(String.valueOf(userDao.findAll().size()));

		// 删除一个User，再验证User总数
		/*
		 * User u = userRepository.findOne(1L); this.logger.info(u.toString());
		 * userRepository.delete(u);
		 * this.logger.info(String.valueOf(userRepository.findAll().size()));
		 * 
		 * // 删除一个User，再验证User总数 u = userRepository.findByUsername("mama").get(0);
		 * this.logger.info(u.toString()); userRepository.delete(u);
		 * this.logger.info(String.valueOf(userRepository.findAll().size()));
		 */

	}

	@Test
	public void test2() throws Exception {

		// 删除一个User，再验证User总数
		List<User> u1 = userDao.findByUsernameLike("kaka");
		this.logger.info(u1.toString());
		List<User> u2 = userDao.findByUsername("mama");
		this.logger.info(u2.toString());
		List<User> u3 = userDao.findByAgeGreaterThan(40);
		this.logger.info(u3.toString());
		List<User> u4 = userDao.findByAgeLessThan(40);
		this.logger.info(u4.toString());
		List<User> u5 = userDao.findByAgeBetween(30, 45);
		this.logger.info(u5.toString());
		List<User> u6 = userDao.findByUsernameNotNull();
		this.logger.info(u6.toString());
		List<User> u7 = userDao.findByUsernameNull();
		this.logger.info(u7.toString());
		List<User> u8 = userDao.findByUsernameNot("kaka");
		this.logger.info(u8.toString());

	}

	@Test
	public void test3() throws Exception {
		Pageable pageable = PageRequest.of(0, 10);
		Page<User> u1 = userDao.findByNameAndAgeRange("kaka", 50, pageable);
		this.logger.info(u1.toString());
		Page<User> u2 = userDao.findByNameAndAgeRange2("kaka", 0, 50, pageable);
		this.logger.info(u2.toString());
		Page<User> u3 = userDao.findByNameAndAgeRange3("kaka", 0, 50, pageable);
		this.logger.info(u3.toString());

	}
}
