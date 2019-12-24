package com.gzz.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzz.aop.RequestLimit;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Controller
public class HelloController {

	@ResponseBody
	@RequestMapping("/hello")
	@RequestLimit(count = 10)
	public String hello(HttpServletRequest request) {
		return "Hello World";
	}

}