package com.lti.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Transaction;

@RestController
public class KafkaBatchProducerController {
	@Autowired 
	KafkaTemplate<String, Transaction> kafkaTemplate;
	
	@GetMapping("/batch/produce")
	public String producer() {
		for(int i=0;i<15;i++) {
			Transaction transaction = new Transaction();
			
			transaction.setName("Arnab");
			transaction.setBalance(new BigDecimal(100));
			transaction.setWithdrawal(new BigDecimal(i));
			transaction.setComment("Arnab has withdrawn " + i);
			transaction.setFinalBalance(new BigDecimal(100 - i));
			
			kafkaTemplate.send("KFP-BATCH", transaction);
		}
		
		return "SUCCESS";
	}
}
