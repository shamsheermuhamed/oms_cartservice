package com.shopping.cart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.cart.exception.ProductNotFoundException;
import com.shopping.cart.model.Cart;
import com.shopping.cart.model.MessageResponse;
import com.shopping.cart.model.Product;
import com.shopping.cart.model.ProductRequest;
import com.shopping.cart.repository.CartRepository;
import com.shopping.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public ResponseEntity<Object> addToCart(ProductRequest productrequest) {
		Cart cart=new Cart();
		String url="http://localhost:8090/api/shopping/product/getproduct/"+productrequest.getProductId();
    	Product ds=template.getForObject(url, Product.class);
    	if(ds!=null) {
    		cart.setProduct(ds);
    		cart.setProductId(productrequest.getProductId());
    		cart.setUserId(productrequest.getUserId());
    		cartRepository.save(cart);
			return  ResponseEntity.ok(new MessageResponse("Product Successfully added to cart"));
		}
		else {
			return ResponseEntity
			.badRequest()
			.body(new MessageResponse("Error: No product found with the productId to add!"));
		}
	}

	@Override
	public List<Product> getProductsByUser(String userId) {
		List<Cart> cartList=cartRepository.findByUserId(userId);
		List<Product> productList=new ArrayList<>();
		if(!cartList.isEmpty()) {
			for(Cart cart:cartList) {
				productList.add(cart.getProduct());
			}
		}
		else {
			throw new ProductNotFoundException();
		}
		return productList;
	}

	@Override
	public ResponseEntity<Object> deleteProductsByUser(String userId) {
		if(userId!=null) {
			cartRepository.deleteByUserId(userId);
			return  ResponseEntity.ok(new MessageResponse("Orders removed from cart"));
		}
		else {
			return  ResponseEntity.ok(new MessageResponse("Not able to remove order"));
		}		
	}

	@Override
	public ResponseEntity<Object> deleteCartProduct(String userId, String productId) {
		List<Cart> cartList=cartRepository.findByUserId(userId);
		if(!cartList.isEmpty()) {
			cartRepository.deleteByUserIdAndProductId(userId,productId);
			return  ResponseEntity.ok(new MessageResponse("Product removed from cart"));
		}
		else {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: No product found with the given product Id!"));
		}	
	}
	
	
}
