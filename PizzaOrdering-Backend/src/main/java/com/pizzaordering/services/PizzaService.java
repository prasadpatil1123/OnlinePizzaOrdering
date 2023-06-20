package com.pizzaordering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaordering.model.Pizza;

public interface PizzaService {

	
	public Pizza addPizza(Pizza pizza); //add
	
	public void deletePizzaById(Long Id); //delete
	
	public Pizza updatePizza(Pizza pizza);
	
	public List<Pizza> findAllPizza(); //findPizza
	
	public Optional<Pizza> PizzaById(Long id);
	
	public List<Pizza> findByCategoryId(long cat_id);
	
	public Pizza getById(Long id);

}