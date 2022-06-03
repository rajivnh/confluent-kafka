package com.lti.endpoint;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Payment {

	@Bean
	public Consumer<String> consumer() {
		return (x) -> System.out.println(x);
	}
	
	@Bean
	public Supplier<String> supplier() {
		return () -> "Hello World!";
	}
	
	@Bean
	public Function<String, String> function() {
		return (x) -> "Hello World! Function " + x;
	}
}
