package com.gzz.sys.user;

import java.util.List;

/**
 * @功能描述 Hessian实例之服务器
 * @author www.gaozz.club
 * @date 2018-08-26
 */
public interface IHelloService {
	String sayHello(String name);

	List<User> queryList(UserCondition cond);
}
