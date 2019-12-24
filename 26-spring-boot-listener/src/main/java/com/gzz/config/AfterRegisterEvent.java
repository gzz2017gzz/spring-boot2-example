package com.gzz.config;

import org.springframework.context.ApplicationEvent;

import com.gzz.user.User;

import lombok.Getter;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Getter
public class AfterRegisterEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private User user;

	public AfterRegisterEvent(Object source, User user) {
		super(source);
		this.user = user;
	}
}
