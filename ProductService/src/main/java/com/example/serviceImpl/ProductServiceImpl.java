package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.exception.ProductServiceException;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long addProduct(ProductRequest productRequest) {
		 Product product = Product.builder()
				 .productName(productRequest.getProductName())
				 .price(productRequest.getPrice())
				 .quantity(productRequest.getQuantity())
				 .build();
		Product saveProduct = productRepository.save(product);
		return saveProduct.getProductId();
	}

	@Override
	public ProductResponse getProductById(Long productId) throws ProductServiceException {
		
	Product product = productRepository.findById(productId)
			                           .orElseThrow(()-> new ProductServiceException("Product id  not Found","Product_Not_Found"));
	ProductResponse productResponse = ProductResponse.builder()
			                          .productId(product.getProductId())
			                          .productName(product.getProductName())
			                          .price(product.getPrice())
			                          .quantity(product.getQuantity())
			                          .build();
		return productResponse;
	}

	@Override
	public void reduceQuantity(Long productId, int quantity) throws ProductServiceException {
		
		log.info(" reduceing Quantity initiated");
		Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceException("Product id  not Found","Product_Not_Found"));
	if(product instanceof Product)	{
		log.info(" Checking Product Quantity");
		if(product.getQuantity() < quantity) {
			throw new ProductServiceException("Not having enough quantity of products","NOT_ENOUGH_QUANTITY");
		}
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
		log.info(" Product Saved in DB");
	 }
	}

}
