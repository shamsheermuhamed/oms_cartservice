package com.shopping.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.ProductRequest;
import com.shopping.cart.model.Product;
import com.shopping.cart.service.CartService;

@RestController
@RequestMapping("/api/shopping")
@CrossOrigin
public class CartController {
	
	@Autowired
	private CartService cartService;

	@PostMapping("/product/addtocart")
	public ResponseEntity<Object> addToCart(@RequestBody ProductRequest product) {
		return cartService.addToCart(product);
	}
	
	@GetMapping("/product/getproductsbyuser/{userId}")
	public List<Product> getProductsByUser(@PathVariable String userId) {
		return cartService.getProductsByUser(userId);
	}
	
	@DeleteMapping("/product/deleteproductsbyuser/{userId}")
	public ResponseEntity<Object> deleteProductsByUser(@PathVariable String userId) {
		return cartService.deleteProductsByUser(userId);
	}
	
	@DeleteMapping("/product/deletecartproduct/{userId}/{productId}")
	public ResponseEntity<Object> deleteCartProduct(@PathVariable String userId,@PathVariable String productId) {
		return cartService.deleteCartProduct(userId,productId);
	}
	
	
	
}
