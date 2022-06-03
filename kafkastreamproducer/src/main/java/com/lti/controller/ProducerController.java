package com.lti.controller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

import org.springframework.cloud.function.context.PollableBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Transaction;

import reactor.core.publisher.Flux;

@RestController
public class ProducerController {
	private BlockingQueue<Flux<Transaction>> unbounded = new LinkedBlockingQueue<>();

	@GetMapping("/stream/producer")
	public String stream() {
		unbounded.offer(Flux.range(0, 10).map(i -> getTransaction(i)).delayElements(Duration.ofMillis(1000)));
		
		return "SUCCESS";
	}
	
    @PollableBean
    public Supplier<Flux<Transaction>> producer() {
    	return () -> {
    		Flux<Transaction> fluxMsg = unbounded.poll();
    		
    		return fluxMsg == null ? Flux.empty() : fluxMsg.switchIfEmpty(Flux.empty());
    	};
    }
    
	private Transaction getTransaction(int i) {
		Transaction transaction = new Transaction();
		
		transaction.setName("Arnab");
		transaction.setBalance(new BigDecimal(100));
		transaction.setWithdrawal(new BigDecimal(i));
		transaction.setComment("Arnab has withdrawn " + i);
		transaction.setFinalBalance(new BigDecimal(100 - i));
		
		return transaction;
	}
}
