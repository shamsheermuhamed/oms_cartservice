package com.shopping.cart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shopping.cart.model.Product;
import com.shopping.cart.model.ProductRequest;

public interface CartService {

	ResponseEntity<Object> addToCart(ProductRequest product);

	List<Product> getProductsByUser(String userId);

	ResponseEntity<Object> deleteProductsByUser(String userId);

	ResponseEntity<Object> deleteCartProduct(String userId, String productId);

}
