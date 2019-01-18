package com.gzz.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author www.gaozz.club
 * @date 2018-08-26
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