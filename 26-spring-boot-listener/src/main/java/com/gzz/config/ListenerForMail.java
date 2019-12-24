package com.gzz.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.gzz.user.User;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Component
public class ListenerForMail {
	@EventListener
//    @Async
	public void sendMail(AfterRegisterEvent afterRegisterEvent) {
		User user = afterRegisterEvent.getUser();
		System.out.println("发邮件:" + user.getName() + "，密码：" + user.getPassword());
	}
}
