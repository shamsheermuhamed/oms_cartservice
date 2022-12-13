package com.shopping.cart.model;

public class ProductRequest {
	
	String userId;
	String productId;
	
	public ProductRequest(String userId, String productId) {
		this.userId = userId;
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
