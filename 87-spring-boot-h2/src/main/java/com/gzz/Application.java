package com.gzz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		List<User> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(User.builder().name("李四" + i).create_time(new Date()).age(i).phone(i + "").sex("1").build());
		}
		long start = System.currentTimeMillis();
		dao.insertBatch(list);
		log.info("插入1000条记录使用{}毫秒！", System.currentTimeMillis() - start);
		dao.save(User.builder().name("李四光").create_time(new Date()).age(20).phone("13588887777").sex("0").build());
//		log.info(JSON.toJSONString(dao.queryList(UserCond.builder().build())));
		log.info(JSON.toJSONString(dao.queryPage(UserCond.builder().build())));
	}
}
