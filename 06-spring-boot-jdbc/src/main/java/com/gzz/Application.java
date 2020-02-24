package com.gzz;

import java.util.List;

import javax.annotation.PostConstruct;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzz.sys.user.User;
import com.gzz.sys.user.UserCond;
import com.gzz.sys.user.UserDao;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Slf4j
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserDao dao;

	@PostConstruct
	public void run() {
		UserCond cond = UserCond.builder()//
				.gender((byte) 1)//
				.ids(Arrays.asList(new Integer[] { 1 }))//
				.build();
		List<User> list = dao.queryList(cond);
		log.info("list={}", list);

		int delete = dao.delete(new Integer[] { 1 });
		log.info("delete count={}", delete);
	}
}
