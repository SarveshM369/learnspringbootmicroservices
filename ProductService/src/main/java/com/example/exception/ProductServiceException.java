package com.example.exception;

import lombok.Data;

@Data
public class ProductServiceException extends Exception{
 
	private String errorcode;
	
	public ProductServiceException(String message, String errorcode) {
		super(message);
		this.errorcode=errorcode;
	}
	
}
