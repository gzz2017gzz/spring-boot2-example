package com.gzz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.fastjson.JSON;
import com.gzz.sys.user.User;
import com.gzz.sys.user.UserCond;
import com.gzz.sys.user.UserDao;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserDao dao;

	@PostConstruct
	private void run() {
//		for (int i = 0; i < 10000; i++)
		dao.save(User.builder().name("张三丰").build());
		dao.save(User.builder().name("张三").build());

		log.info(JSON.toJSONString(dao.queryList(UserCond.builder().build())));
		log.info(JSON.toJSONString(dao.queryPage(UserCond.builder().build())));

	}
}
