package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@EnableSolrRepositories(basePackages = "com.lti.persistence")
@SpringBootApplication
public class KafkaSolrConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSolrConsumerApplication.class, args);
	}
}
