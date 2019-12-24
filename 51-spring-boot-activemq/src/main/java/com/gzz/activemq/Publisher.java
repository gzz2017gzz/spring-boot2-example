package com.gzz.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Service
public class Publisher {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	public void publish(String destinationName, String message) {
		Destination destination = new ActiveMQTopic(destinationName);
		System.out.println("==>>发布topic消息 " + message);
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
}