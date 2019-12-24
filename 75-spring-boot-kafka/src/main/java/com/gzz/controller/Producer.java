package com.gzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试kafka生产者
 * 
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@RestController
@RequestMapping("kafka")
public class Producer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("send")
	public String send(String msg) {
		System.out.println("123123123");
		kafkaTemplate.send("test_topic", msg);
		return "success";
	}
}
