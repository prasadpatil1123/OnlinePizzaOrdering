package com.pizzaordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.Order;
//import com.pizzaordering.model.OrderItem;

//@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

	Order findByCartOwnerId(long id);
}
