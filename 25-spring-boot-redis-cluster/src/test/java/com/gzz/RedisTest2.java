package com.gzz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.gzz.vo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest2 {

	Log logger = LogFactory.getLog(getClass());

	@Autowired
	private RedisTemplate<String, List<User>> template;

	@Test
	public void run() {
		ValueOperations<String, List<User>> opsForValue = template.opsForValue();

		List<User> list = new ArrayList<>();
		list.add(new User(1, "张三丰"));
		list.add(new User(2, "李四光"));

		opsForValue.set("userlist", list);
		template.delete("userlist");
		logger.info(opsForValue.get("userlist"));
	}

}