package com.thiru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiru.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
