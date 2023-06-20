package com.pizzaordering.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.CartItem;

//@Repository
public interface CartItemDao extends JpaRepository<CartItem, Long> {
	
	CartItem findByPizzaIdAndCartId(long pizza_id,Long id);
	
	List<CartItem> findByCartId(Long id);
}
