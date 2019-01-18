package com.gzz.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.gzz.rabbit.TopicRabbitConfig;

@Component
@RabbitListener(queues = TopicRabbitConfig.infomation)
public class TopicReceiver2 {

	@RabbitHandler
	public void process(String message) {
		System.out.println("Topic Receiver2  : " + message);
	}

}
