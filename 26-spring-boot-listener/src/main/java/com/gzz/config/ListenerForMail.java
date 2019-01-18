package com.gzz.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.gzz.user.User;

@Component
public class ListenerForMail {
	@EventListener
//    @Async
	public void sendMail(AfterRegisterEvent afterRegisterEvent) {
		User user = afterRegisterEvent.getUser();
		System.out.println("发邮件:" + user.getName() + "，密码：" + user.getPassword());
	}
}
