package com.ordermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ordermicroservice.entity.Order;
import com.ordermicroservice.entity.Payment;
import com.ordermicroservice.service.OrderService;
import com.ordermicroservice.service.TrasactionRequest;
import com.ordermicroservice.service.TrasactionResp;

@RestController
@RequestMapping("/order")
public class Controller {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/bookorder")
	public TrasactionResp bookOrder(@RequestBody TrasactionRequest tr) {
		
		 try {
			return service.saveOrder(tr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
