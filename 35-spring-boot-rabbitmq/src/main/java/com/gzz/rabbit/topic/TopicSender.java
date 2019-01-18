package com.gzz.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gzz.rabbit.TopicRabbitConfig;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send1() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("exchange", TopicRabbitConfig.message, context);
	}

	public void send2() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("exchange", TopicRabbitConfig.infomation, context);
	}
}