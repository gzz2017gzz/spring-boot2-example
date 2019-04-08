package com.gzz;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.gzz.service.AsyncService;

@SpringBootApplication
@EnableAsync
public class Application {
	private Log logger = LogFactory.getLog(getClass());
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private AsyncService asyncService;
	
	@PostConstruct
	public void run() {
		logger.info("1 ");
		asyncService.update(1);
		logger.info("2");
		
	}
}
