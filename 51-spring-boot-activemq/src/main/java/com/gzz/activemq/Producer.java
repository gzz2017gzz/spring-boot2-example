package com.gzz.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
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