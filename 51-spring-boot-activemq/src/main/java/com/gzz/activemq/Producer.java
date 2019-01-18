package com.gzz.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@Service
public class Producer {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	public void sendMsg(String destinationName, String message) {
		System.out.println("==>>发送queue消息 " + message);
		Destination destination = new ActiveMQQueue(destinationName);
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
}