package com.pizzaordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaordering.services.AddressService;
import com.pizzaordering.services.OfferService;
import com.pizzaordering.services.PizzaService;
import com.pizzaordering.services.ReviewService;
import com.pizzaordering.services.ShoppingCartService;
import com.pizzaordering.services.UsersService;

@RestController
public class DeliveryPersonController {
	
	@Autowired
	UsersService userService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@GetMapping("/test")
	public void getCartTest() {
		shoppingCartService.addToCart((long)10, (long)4);
	}
}
