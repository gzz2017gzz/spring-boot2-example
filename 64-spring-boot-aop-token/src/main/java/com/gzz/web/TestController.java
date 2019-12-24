package com.gzz.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.aop.NoRepeatSubmit;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@RestController
public class TestController {

	@GetMapping("/getToken")
	public String getToken(HttpServletRequest request) {
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", uuid);
		return (String) request.getSession().getAttribute("token");
	}

	@NoRepeatSubmit(removeToken = true)
	@RequestMapping("/save")
	public String save() {
		return "success";
	}

	@RequestMapping("/update")
	public String update() {
		return "success";
	}

}