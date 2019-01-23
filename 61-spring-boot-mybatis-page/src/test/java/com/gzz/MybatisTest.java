package com.gzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzz.user.User;
import com.gzz.user.UserMapper;

/**
 * @author Levin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

	private static final Logger log = LoggerFactory.getLogger(MybatisTest.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test2() {

		PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc")
				.doSelectPageInfo(() -> this.userMapper.selectAll());
		log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

		PageHelper.startPage(1, 10).setOrderBy("id desc");
		final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
		log.info("[普通写法] - [{}]", userPageInfo);
	}

//	@Test
	public void test1() {
		User user1 = new User("u1", "p1");
		userMapper.insertSelective(user1);
		int count = userMapper.countByUsername("u1");
		log.info("[调用自己写的SQL] - [{}]", count);

	}
}
