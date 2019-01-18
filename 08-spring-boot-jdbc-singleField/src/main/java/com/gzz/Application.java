package com.gzz;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gzz.dao.UserDao;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserDao dao;

	@PostConstruct
	public void run() {
		dao.query1();
		dao.query2();
		dao.query3();
	}
}
