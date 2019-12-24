package com.gzz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@SpringBootApplication
public class Application {
	private static final Log logger = LogFactory.getLog(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		logger.info("info");
		logger.debug("debug");
		logger.error("error");
	}
}
