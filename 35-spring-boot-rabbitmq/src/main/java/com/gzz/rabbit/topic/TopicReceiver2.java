package com.gzz.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.gzz.rabbit.TopicRabbitConfig;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Component
@RabbitListener(queues = TopicRabbitConfig.infomation)
public class TopicReceiver2 {

	@RabbitHandler
	public void process(String message) {
		System.out.println("Topic Receiver2  : " + message);
	}

}
