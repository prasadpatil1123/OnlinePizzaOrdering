package com.pizzaordering.services;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaordering.dao.OrderDao;
import com.pizzaordering.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	// add order
	@Override
	public Order addOrder(Order order) {
		orderDao.save(order);
		return order;
	}

	// get order by order id
	@Override
	public Optional<Order> findOrderById(long id) {
		System.out.println("Finding the order with the order Id: " + id);
		return orderDao.findById(id);
	}

	// get order by userId/cartOwnerId
	@Override
	public Order findOrderByUserId(long id) {
		return orderDao.findByCartOwnerId(id);
	}

	// get all orders
	@Override
	public List<Order> findAllOrders() {
		return orderDao.findAll();
	}

	// delete order by order id
	@Override
	public void deleteOrderById(long id) {
		orderDao.deleteById(id);
	}

	// update order
	@Override
	public Order updateOrder(Order order) {
		Order updOrder = orderDao.findById(order.getId()).orElse(null);

		updOrder.setTotalItems(order.getTotalItems());
		updOrder.setTotalOrderPrice(order.getTotalOrderPrice());
		updOrder.setOrderCreatedOn(order.getOrderCreatedOn());
		updOrder.setCartOwner(order.getCartOwner());
		updOrder.setOrderItems(order.getOrderItems());
		updOrder.setPlacedOn(order.getPlacedOn());
		updOrder.setStatus(order.getStatus());
		updOrder.setAddress(order.getAddress());

		return updOrder;
	}

	// find order by id
	@Override
	public Order findByID(Long id) {
		return orderDao.findById(id).orElse(null);
	}

}
