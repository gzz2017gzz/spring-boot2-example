package com.gzz.service;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	private Log logger = LogFactory.getLog(getClass());

	@Async
	public void update(int num) {
		try {
			 TimeUnit.SECONDS.sleep(1);//秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("传入参数是:" + num);
	}

}
