package com.gzz;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzz.model.Employee;
import com.gzz.model.Person;
import com.gzz.model.Role;
import com.gzz.model.User;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@SpringBootApplication
public class Application {

	private static final Log logger = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		User user = new User();
		user.setBirthday(new Date());
		user.setId(1L);
		user.setName("张三");
		logger.info(user);
		Person person = new Person();
		person.setBirthday(new Date());
		person.setId(1L);
		person.setName("张三");
		logger.info(person);
		Role role = Role.builder().birthday(new Date()).id(1L).name("李四").build();
		logger.info(role);

		Employee employee = new Employee();
		employee.setBirthday(new Date()).setId(1L).setName("王五");
		logger.info(employee);
	}

}