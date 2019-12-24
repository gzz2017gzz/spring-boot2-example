package com.gzz.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
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
