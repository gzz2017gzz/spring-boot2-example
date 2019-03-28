package com.gzz.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafKaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Scheduled(fixedDelay = 1000)
	public void productor() {
		kafkaTemplate.send("gzz", "代码生成器演示(http://www.gaozz.club)" + new Date());
	}

	@KafkaListener(topics = "gzz", groupId = "Consumer1")
	public void Consumer1(ConsumerRecord<?, ?> record) {
		System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
	}

	@KafkaListener(topics = "gzz", groupId = "Consumer2")
	public void Consumer2(ConsumerRecord<?, ?> record) {
		System.out.printf("topic = %s, offset = %d, value = %s,time=%d \n", record.topic(), record.offset(), record.value(), record.timestamp());
	}
}
