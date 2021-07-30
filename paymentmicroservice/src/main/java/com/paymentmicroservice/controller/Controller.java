package com.paymentmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentmicroservice.entity.Payment;
import com.paymentmicroservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class Controller {
	
	@Autowired
	PaymentService service;
	
	@PostMapping("/dopayment")
	public Payment doPayment(@RequestBody Payment p) {
		return service.savePayment(p);
	}
	
	

}
