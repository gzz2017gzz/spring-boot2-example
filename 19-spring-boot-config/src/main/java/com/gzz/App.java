package com.gzz;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzz.config.ConfigBean;
import com.gzz.config.User;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@SpringBootApplication
public class App {
	private static final Log logger = LogFactory.getLog(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private int age;
	@Autowired
	private ConfigBean configBean;
	@Autowired
	private User user;

	@PostConstruct
	public void test() {
		logger.info(configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean.getUuid() + " >>>>"
				+ configBean.getMax());

		logger.info(user.getName() + user.getAge());

		logger.info(name + ":" + age);
	}
}
