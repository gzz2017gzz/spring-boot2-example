package com.gzz;

import java.util.ArrayList;
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

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserDao dao;

	@PostConstruct
	private void run() {
		List<User> list = new ArrayList<>();
		int count = 20000;
		for (int i = 0; i < count; i++)
			list.add(User.builder().name("张三丰" + i).build());
		long start = System.currentTimeMillis();
		dao.insertBatch(list);
		UserCond cond = new UserCond();
		cond.setSize(100);
		cond.setPage(100);
	
		log.info("插入{}条记录,共需要{}毫秒.", count, System.currentTimeMillis() - start);
//		dao.save(User.builder().name("张三").build());
		log.info(JSON.toJSONString(dao.queryPage(cond)));
	}
}
