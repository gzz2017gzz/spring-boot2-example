package com.gzz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.config.ApiResult;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
public class IndexController {

	@RequestMapping(value = "/index/{number}")
	public ApiResult<Integer> index(@PathVariable int number) {
		return new ApiResult<Integer>(20 / number, 1);
	}
}
//http://localhost:8080/index/0
//http://localhost:8080/index/10