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
		int count = 2000;
		List<User> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			list.add(User.builder().name("李四" + i).create_time(new Date()).age(i).phone(13580805392L + i + "").sex("1").build());
		}
		long start = System.currentTimeMillis();
		dao.insertBatch(list);
		log.info("插入{}条记录使用{}毫秒！", count, System.currentTimeMillis() - start);
		log.info(JSON.toJSONString(dao.queryPage(UserCond.builder().build())));
	}
}
