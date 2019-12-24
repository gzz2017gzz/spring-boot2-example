package com.gzz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest1 {

	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Test
	public void test1() throws Exception {

		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("hello", "hello");

		logger.info(opsForValue.get("hello"));

	}
}