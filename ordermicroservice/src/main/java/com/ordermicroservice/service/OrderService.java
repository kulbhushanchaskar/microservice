package com.ordermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordermicroservice.dao.OrderRepo;
import com.ordermicroservice.entity.Payment;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Service
@RefreshScope
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String endPointURL;
	
	Logger logger= LoggerFactory.getLogger(OrderService.class);
	
	public TrasactionResp saveOrder(TrasactionRequest tr) throws JsonProcessingException {
		logger.debug("OrderService Request : "+new ObjectMapper().writeValueAsString(tr));
		String msg = "";
		Payment payment = tr.getPayment();
		payment.setOrderid(tr.getOrder().getId());
		payment.setAmount(tr.getOrder().getPrice());
		
//		endPointURL = "http://PAYMENTSERVICE/payment/dopayment";
		
		Payment payResp = restTemplate.postForObject(endPointURL, payment, Payment.class);
		
		if(payResp.getPaymentstatus().equalsIgnoreCase("success")) {
			msg = "Payment Processing Success";
		} else {
			msg=  "Payment Processing Failed";
		}
		logger.debug("OrderService getting Response from PaymentService : "+new ObjectMapper().writeValueAsString(msg));
		return new TrasactionResp(tr.getOrder(), payResp.getTrasid(), payResp.getAmount(), msg);
		//return orderRepo.save( tr.getOrder());
//		return tr.getOrder();
	}

}
