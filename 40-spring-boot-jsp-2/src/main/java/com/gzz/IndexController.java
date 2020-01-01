package com.gzz;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = { "/", "index", "index.html" })
	public String index(HttpServletRequest request) {
		logger.info("有人访问了主页");
		request.setAttribute("name", "gzz");
		request.setAttribute("msg", "我是服务器信息");
		return "index.jsp";
	}
}
