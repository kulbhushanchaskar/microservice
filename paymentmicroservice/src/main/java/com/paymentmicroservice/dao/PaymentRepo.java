package com.paymentmicroservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentmicroservice.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
