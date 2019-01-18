package com.gzz.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.gzz.user.User;

@Component
public class ListenerForLog {
	@EventListener
//	@Async
	public void recordLog(AfterRegisterEvent afterRegisterEvent) {
		User user = afterRegisterEvent.getUser();
		System.out.println("记日志,用户名" + user.getName() + "，密码：" + user.getPassword());
	}
}
