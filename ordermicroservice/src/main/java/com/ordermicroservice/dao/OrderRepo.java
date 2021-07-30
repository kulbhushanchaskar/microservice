package com.ordermicroservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermicroservice.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
