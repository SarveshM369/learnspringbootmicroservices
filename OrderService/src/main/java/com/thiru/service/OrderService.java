package com.thiru.service;

import com.thiru.model.OrderRequest;

public interface OrderService {

	Long placeOrder(OrderRequest orderRequest);

}
