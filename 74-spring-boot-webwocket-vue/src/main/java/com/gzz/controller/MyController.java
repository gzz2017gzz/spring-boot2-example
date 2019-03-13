package com.gzz.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@Scheduled(fixedDelay = 2000)
	public void send() {
		CustomWebSocket.sendInfo("Hello,kungfupeng!");
	}
}
