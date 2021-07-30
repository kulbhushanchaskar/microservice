package com.ordermicroservice.service;

import com.ordermicroservice.entity.Order;
import com.ordermicroservice.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrasactionResp {
	
	private Order o;
	private String transid;
	private double amt;
	private String msg;

}
