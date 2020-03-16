package com.gzz.controller;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redisson")
public class RedissonController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String PRODUCT_KEY = "productKey";
	private static final String LOCK_KEY = "redissonLock";
	@Autowired
	private RedissonClient redissonClient;

	@RequestMapping("/lock")
	public void lock() {
		RLock lock = redissonClient.getLock(LOCK_KEY);
		// 设置5秒过期时间
		lock.lock(5, TimeUnit.SECONDS);
		String lockValue = lock.getName();
		logger.info("[{}]成功获取锁，开始执行业务。。。", lockValue);
		RAtomicLong atomicLong = redissonClient.getAtomicLong(PRODUCT_KEY);
		long surplus = atomicLong.getAndIncrement();
		if (surplus <= 0) {
			lock.unlock();
			logger.info("[{}]库存不足，释放锁 ##########################################", lockValue);
			return;
		}
		logger.info("[{}]当前库存[{}]，库存 -1，剩余库存[{}]", lockValue, surplus, atomicLong.decrementAndGet());
		logger.info("[{}]操作完成，释放锁", lockValue);
		lock.unlock();
	}

}
