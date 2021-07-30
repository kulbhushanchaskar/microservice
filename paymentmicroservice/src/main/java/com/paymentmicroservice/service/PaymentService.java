package com.paymentmicroservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentmicroservice.dao.PaymentRepo;
import com.paymentmicroservice.entity.Payment;

@Service
public class PaymentService {
	
	
	@Autowired
	PaymentRepo repo;
	
	public Payment savePayment(Payment payment) {
		
		payment.setPaymentstatus("success");
		payment.setTrasid(UUID.randomUUID().toString());
		return repo.save(payment);
		
	}
	
	

}
