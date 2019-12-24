package com.gzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.gzz.dao.UserDao;
import com.gzz.entity.User;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void testSaveUser() throws Exception {
		User user = User.builder().id(2l).userName("小明").passWord("fffooo123").build();
		userDao.saveUser(user);
	}

	@Test
	public void findUserByUserName() {
		User user = userDao.findUserByUserName("小明");
		log.info("user is " + user);
	}

	@Test
	public void updateUser() {
		User user = User.builder().id(2l).userName("天空").passWord("fffxxxx").build();
		userDao.updateUser(user);
	}

	@Test
	public void deleteUserById() {
		userDao.deleteUserById(1l);
	}

}
