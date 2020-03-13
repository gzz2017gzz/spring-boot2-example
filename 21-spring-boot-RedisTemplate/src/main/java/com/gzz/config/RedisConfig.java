package com.gzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Configuration
public class RedisConfig {
	@Bean
	<K, V> RedisTemplate<K, V> getRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<K, V> redisTemplate = new RedisTemplate<K, V>();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
}