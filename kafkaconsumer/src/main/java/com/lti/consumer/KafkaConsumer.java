package com.lti.consumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.lti.model.Transaction;

@EnableKafka
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "KFP", groupId = "KFP-GROUP")
	public void consumer(Transaction transaction) {
		System.out.println("Name " + transaction.getName());
	}
}
