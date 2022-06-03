package com.lti.consumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.lti.model.Transaction;

@EnableKafka
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "KFP", groupId = "KFP-GROUP")
	public void consumer(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, Transaction transaction) throws Exception {
		System.out.println(partition + " --- " + transaction.getName());
	}
}
