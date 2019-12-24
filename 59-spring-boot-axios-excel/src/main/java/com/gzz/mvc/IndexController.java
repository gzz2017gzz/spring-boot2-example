package com.gzz.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
