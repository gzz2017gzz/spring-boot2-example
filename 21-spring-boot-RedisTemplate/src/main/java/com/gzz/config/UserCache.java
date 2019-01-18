package com.gzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.gzz.user.User;

@Component
public class UserCache {
	@Autowired
	private RedisTemplate<String, User> template;

	public User get(String member_no) {
		ValueOperations<String, User> opsForValue = template.opsForValue();
		return opsForValue.get(member_no);
	}

	public void set(String key, User user) {
		ValueOperations<String, User> opsForValue = template.opsForValue();
		opsForValue.set(user.getMember_no(), user);
	}
}
