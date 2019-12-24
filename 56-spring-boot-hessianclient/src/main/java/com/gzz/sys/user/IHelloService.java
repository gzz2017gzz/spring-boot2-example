package com.gzz.sys.user;

import java.util.List;

/**
 * @功能描述 Hessian实例之客户端
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public interface IHelloService {

	String sayHello(String name);

	List<User> queryList(UserCondition cond);
}
