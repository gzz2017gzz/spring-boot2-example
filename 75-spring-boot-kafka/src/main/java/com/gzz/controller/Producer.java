package com.gzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试kafka生产者
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
