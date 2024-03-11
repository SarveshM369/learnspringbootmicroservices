package com.thiru.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

	private Long productId;
	private int quantity;
	private Double amount;
	private PaymentMode paymentmode;
	
//	private Instant orderDate;
//	private String orderStatus;
	
}
