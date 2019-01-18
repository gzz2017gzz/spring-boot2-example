package com.gzz.config;

import org.springframework.context.ApplicationEvent;

import com.gzz.user.User;

import lombok.Getter;

@Getter
public class AfterRegisterEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private User user;

	public AfterRegisterEvent(Object source, User user) {
		super(source);
		this.user = user;
	}
}
