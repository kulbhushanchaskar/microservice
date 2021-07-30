package com.paymentmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentmicroserviceApplication.class, args);
	}

}
