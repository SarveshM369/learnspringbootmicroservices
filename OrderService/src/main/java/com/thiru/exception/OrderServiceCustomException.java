package com.thiru.exception;

import lombok.Data;

@Data
public class OrderServiceCustomException extends Exception {

	private String errorcode;
	
	public OrderServiceCustomException(String message, String errorcode) {
		super(message);
		this.errorcode=errorcode;
	}
}
