package com.gzz.controller;

import java.time.LocalDateTime;

 
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
