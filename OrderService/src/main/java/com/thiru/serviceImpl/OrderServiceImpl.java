package com.thiru.serviceImpl;

import java.time.Instant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiru.client.ProductService;
import com.thiru.entity.Order;
import com.thiru.model.OrderRequest;
import com.thiru.repository.OrderRepository;
import com.thiru.service.OrderService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository  orderRepository;
	
	@Autowired
	private ProductService productService;

	@Override
	public Long placeOrder(OrderRequest orderRequest) {
		log.info("Before placing order");
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("After Checking Product Availability for the Product"+orderRequest.getProductId());
		Order order = Order.builder()
				      .productId(orderRequest.getProductId())
				      .price(orderRequest.getAmount())
				      .orderDate(Instant.now())
				      .orderStatus("CREATED")
				      .quantity(orderRequest.getQuantity())
				      .build();
		log.info("Order Placed");
		orderRepository.save(order);
		log.info("Product Saved Successfully after Placing order");
		return order.getOrderId();
	}
}
