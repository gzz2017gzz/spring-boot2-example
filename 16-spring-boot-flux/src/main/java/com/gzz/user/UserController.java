package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
public class UserController {

	@Autowired
	private UserDao userdao;

	@RequestMapping("/")
	public String hello() {
		return "hello!";
	}

	@RequestMapping("/findById")
	public Mono<User> findById(String id) {
		return Mono.just(userdao.findById(id));
	}

	@RequestMapping("/queryList")
	public Flux<User> list() {
		return Flux.fromIterable(userdao.queryList());
	}

}
