package com.gzz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static Log logger = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
		for (int i = 0; i < 20; i++) {
			logger.info("输出info");
			logger.debug("输出debug+skkkw嗡嗡嗡kw");
			logger.error("输出error  嗡嗡嗡我");
		}
	}
}
