package com.gzz.sys.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @功能描述 Hessian实例之服务器
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@Service("HelloService")
public class HelloService implements IHelloService {
	@Override
	public String sayHello(String name) {
		return "Hello World! " + name;
	}

	@Override
	public List<User> queryList(UserCondition cond) {
		System.out.println(cond);
		List<User> list = new ArrayList<>();
		list.add(new User(1, "张三", new Date()));
		list.add(new User(2, "李四", new Date()));
		return list;
	}
}
