package com.gzz.controller;

import java.time.LocalDateTime;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public class Order {

	// @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime payTime;

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}
}
