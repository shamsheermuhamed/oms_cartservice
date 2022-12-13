package com.shopping.cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shopping.cart.model.Cart;
import com.shopping.cart.model.Product;


public interface CartRepository extends MongoRepository<Cart, String> {

	List<Cart> findByUserId(String userId);

	void deleteByUserId(String userId);
	
//	@Query("{'product.id' : ?0}")
	@Query(value= "{$and : [{userId: ?0}, {productId : ?1}]}", delete=true)
	void deleteByUserIdAndProductId(String userId, String productId); 

}
