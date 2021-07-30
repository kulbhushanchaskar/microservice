package com.springapigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Controller {
	
	@RequestMapping("/orderfallback")
	public Mono<String> orderServiceFallBack() {
		return Mono.just("Order service is not working");
	}
	
	
	@RequestMapping("/paymentfallback")
	public Mono<String> paymentServiceFallBack() {
		return Mono.just("payment service is not working");
	}

}
