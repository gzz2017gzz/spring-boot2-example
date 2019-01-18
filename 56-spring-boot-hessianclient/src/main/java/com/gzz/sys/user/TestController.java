package com.gzz.sys.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @功能描述 Hessian实例之客户端
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@RestController
public class TestController {

	@Autowired
	private IHelloService helloService;

	@RequestMapping("/test")
	public String test() {
		return helloService.sayHello("Spring boot with Hessian.");
	}

	@RequestMapping("/queryList")
	public List<User> queryList() {
		List<User> queryList = helloService.queryList(new UserCondition(1, "王五", new Date()));
		for (User user : queryList) {
			System.out.println(user);
		}
		return queryList;
	}
}
