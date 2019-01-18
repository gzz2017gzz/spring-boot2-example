package com.gzz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.gzz.user.User;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private RedisTemplate<String, User> template;

	@PostConstruct
	public void test() {
		ValueOperations<String, User> opsForValue = template.opsForValue();
//		User user = new User();
//		user.setAge(12);
//		user.setMember_no("gzztest");
//		user.setName("高振中");
//		opsForValue.set(user.getMember_no(), user);
		System.out.println(opsForValue.get("gzztest"));

	}
}
