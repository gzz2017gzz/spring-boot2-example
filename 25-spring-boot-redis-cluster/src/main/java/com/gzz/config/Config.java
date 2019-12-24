package com.gzz.config;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class Config {
	Log logger = LogFactory.getLog(getClass());
	private List<String> nodes;

	@Bean
	public RedisConnectionFactory getFactory() {
		logger.info("结点信息:" + nodes);
		// List<String> list = Arrays.asList("192.168.1.91:7001",
		// "192.168.1.91:7002", "192.168.1.91:7003",
		// "192.168.1.91:7004", "192.168.1.91:7005", "192.168.1.91:7006");
		RedisClusterConfiguration cluster = new RedisClusterConfiguration(nodes);
		return new JedisConnectionFactory(cluster, getPoolConfig());
	}

	@Bean
	public JedisPoolConfig getPoolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(8);
		return poolConfig;
	}

	@Bean
	<K, V> RedisTemplate<K, V> getRedisTemplate() {
		RedisTemplate<K, V> redisTemplate = new RedisTemplate<K, V>();
		redisTemplate.setConnectionFactory(getFactory());
		return redisTemplate;
	}

	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}

}