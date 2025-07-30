package com.agrohubconnect.producers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AgrohubProducersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgrohubProducersServiceApplication.class, args);
	}

}
