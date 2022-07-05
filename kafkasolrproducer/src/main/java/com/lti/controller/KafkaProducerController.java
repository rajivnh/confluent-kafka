package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.ProductData;

@RestController
public class KafkaProducerController {
	@Autowired 
	KafkaTemplate<String, ProductData> kafkaTemplate;
	
	@GetMapping("/produce")
	public String producer() {
		ProductData productData = new ProductData();
		
		productData.setId(String.valueOf((int) (Math.random() * (1000 - 200)) + 200));
		productData.setName("MARSH - " + productData.getId());
		
		kafkaTemplate.send("KAFSOLR", productData);
		
		return "SUCCESS";
	}
}
