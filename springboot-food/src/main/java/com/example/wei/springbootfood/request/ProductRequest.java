package com.example.wei.springbootfood.request;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {

	private String productName;
	
	private Integer productPrice;


	public ProductRequest(String productName, Integer productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public ProductRequest() {
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

}
