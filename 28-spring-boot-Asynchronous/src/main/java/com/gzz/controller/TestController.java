package com.gzz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.AsyncService;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
public class TestController {
	@Autowired
	private AsyncService asyncService;
	private Log logger = LogFactory.getLog(getClass());

	@RequestMapping("push")
	public String call(int number) {
		long start = System.currentTimeMillis();
		asyncService.update(number); // ★ 假设这个方法会比较耗时，需要异步执行
		logger.info(System.currentTimeMillis() - start);
		return "ok";
	}
}
