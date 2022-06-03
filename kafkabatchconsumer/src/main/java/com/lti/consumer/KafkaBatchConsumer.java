package com.lti.consumer;

import java.util.List;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.lti.model.Transaction;

@EnableKafka
@Component
public class KafkaBatchConsumer {

	@KafkaListener(topics = "KFP-BATCH", groupId = "KFP-BATCH-GROUP")
	public void consumer(List<Transaction> transactions) {
		System.out.println("Transaction size " + transactions.size());
	}
}
