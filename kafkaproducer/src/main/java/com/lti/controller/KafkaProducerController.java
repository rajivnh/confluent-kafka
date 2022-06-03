package com.lti.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Transaction;

@RestController
public class KafkaProducerController {
	@Autowired 
	KafkaTemplate<String, Transaction> kafkaTemplate;
	
	@GetMapping("/produce")
	public String producer() {
		Transaction transaction = new Transaction();
		
		transaction.setName("Arnab");
		transaction.setBalance(new BigDecimal(100));
		transaction.setWithdrawal(new BigDecimal(20));
		transaction.setComment("Arnab has withdrawn 20");
		transaction.setFinalBalance(new BigDecimal(80));
		
		kafkaTemplate.send("KFP", transaction);
		
		return "SUCCESS";
	}
}
