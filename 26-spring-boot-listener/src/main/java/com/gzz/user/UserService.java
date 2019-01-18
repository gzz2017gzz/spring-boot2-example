package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.gzz.config.AfterRegisterEvent;

@Service
public class UserService {
	@Autowired
	private ApplicationContext context;

	public void register(User user) {
		// 其它逻辑
		context.publishEvent(new AfterRegisterEvent(this, user));
	}
}
