package com.pizzaordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.ShoppingCart;

//@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {
	
	ShoppingCart findByCartOwnerId(long id);
}
