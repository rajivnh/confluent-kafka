package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class ReactiveEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveEndpointApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> resource() {
	    return RouterFunctions.resources("/static/**", new ClassPathResource("static/"));
	}
}
