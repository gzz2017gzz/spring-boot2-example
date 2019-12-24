package com.gzz.service;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Service
public class AsyncService {
	private Log logger = LogFactory.getLog(getClass());

	@Async
	public void update(int num) {
		try {
			 TimeUnit.SECONDS.sleep(20);//秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("传入参数是:" + num);
	}

}
