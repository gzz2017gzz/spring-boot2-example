package com.gzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.config.NoRepeatSubmit;

/**
 * @功能描述 测试Controller
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@RestController
public class TestController {
	@RequestMapping("/test")
	@NoRepeatSubmit
	public String test() {
		return "程序逻辑返回";
	}

}
