package com.gzz.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("Receiver  : " + hello);
	}

}
