package com.shopping.cart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class Cart {

	  @Id
	  private String id;	  
	  private String productId;
	  private Product product;
	  
	  private String userId;
	  
	  

	public Cart() {
	}

	public Cart(Product product, String userId, String productId) {
		super();
		this.product = product;
		this.userId = userId;
		this.productId=productId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
