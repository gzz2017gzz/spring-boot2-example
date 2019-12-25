package com.gzz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = { "", "/", "index", "index.html" })
	public String index() {
		logger.info("有人访问了主页");
		return "index.jsp";
	}
}
