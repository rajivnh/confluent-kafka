package com.lti.consumer;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.lti.model.Transaction;

import reactor.core.publisher.Flux;

@Component
public class KafkaConsumer {
    @Bean
    public Consumer<Flux<Transaction>> consumer() {
        return (transaction) -> transaction.subscribe(x -> System.out.println(x.getFinalBalance()));
    }
}
