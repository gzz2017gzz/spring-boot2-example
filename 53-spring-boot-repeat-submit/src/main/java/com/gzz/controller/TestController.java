package com.gzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.config.NoRepeatSubmit;

/**
 * @功能描述 测试Controller
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@RestController
public class TestController {
	@RequestMapping("/test")
	@NoRepeatSubmit
	public String test() {
		return "程序逻辑返回";
	}

}
