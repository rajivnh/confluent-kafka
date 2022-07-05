package com.lti.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.lti.model.ProductData;
import com.lti.persistence.service.ProductService;

@EnableKafka
@Component
public class KafkaConsumer {
	@Autowired
	ProductService productService;
	
	@KafkaListener(topics = "KAFSOLR", groupId = "KAFSOLR-GROUP")
	public void consumer(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, ProductData productData) throws Exception {
		System.out.println(productData.toString());
		
		productService.save(productData);
		
		productService.findAll().forEach(x -> System.out.println(x.getName()));
	}
}