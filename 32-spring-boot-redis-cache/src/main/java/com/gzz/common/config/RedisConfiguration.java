package com.gzz.common.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.gzz.common.base.BaseCondition;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

 
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				// 格式化缓存key字符串
				StringBuilder sb = new StringBuilder();
				// 追加类名
				sb.append(o.getClass().getName());
				// 追加方法名
				sb.append(method.getName());
				// 遍历参数并且追加
				for (Object obj : objects) {
					//sb.append(obj.hashCode());
					BaseCondition cond=	(BaseCondition)obj;
					sb.append(cond.getPage());
					sb.append(cond.getSize());
					sb.append(cond.getCondition());
				}
				
				
				System.out.println("调用Redis缓存Key : " + sb.toString());
				return sb.toString();
			}
		};
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
				.defaultCacheConfig()
				.entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
		return RedisCacheManager.builder(RedisCacheWriter
				.nonLockingRedisCacheWriter(redisConnectionFactory))
				.cacheDefaults(redisCacheConfiguration)
				.build();
	}

}
