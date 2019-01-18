package com.gzz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
