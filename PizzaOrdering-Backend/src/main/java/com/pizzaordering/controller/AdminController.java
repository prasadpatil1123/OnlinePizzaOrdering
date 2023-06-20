package com.pizzaordering.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaordering.model.*;

import com.pizzaordering.services.*;

//import com.pizzaordering.dao.*;

@RestController
//@CrossOrigin("")
public class AdminController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	ReviewService reviewService;
	
	
	@Autowired 
	OrderService orderService;
	
	
//Category added by admin---------------------------------------------------------------------------------------------------
	
	//add category
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		this.categoryService.addCategory(category);
		return category;
	}
	
	//edit category
	@PutMapping("/editcategory")
	public Category updateCategory(@RequestBody Category category) {
		System.out.println(category);
		return this.categoryService.editCategoryById(category);
	}
	
	
	//get category by id
	@GetMapping("/category/id/{id}")
	public Optional<Category> getCategoryById(@PathVariable long id){
		System.out.println("in fetch Category of user  " + id);
		return categoryService.findCategoryById(id);
	}
	
	//get all categories
	@GetMapping("/categories")
	public List<Category> seeAllCategory(){
		return categoryService.allCategory();
	}
	
	//delete category by id
	@DeleteMapping("/category/id/{id}")
	public  void deleteCategoryById(@PathVariable long id) {
		categoryService.deleteCategoryById(id);
	}
	
	
//Pizza =>  handle by admin---------------------------------------------------
	
	//Add Pizza by admin
	@PostMapping("/addpizza")
	public Pizza addPizza(@RequestBody Pizza pizza) {
		this.pizzaService.addPizza(pizza);
		return pizza;
	}
	
	//edit pizza by admin
	@PutMapping("/editpizza")
	 public Pizza editPizza(@RequestBody Pizza pizza) {
		return this.pizzaService.updatePizza(pizza);
	}
	
	//delete pizza by admin which admin has added
	@DeleteMapping("/deletepizza/id/{id}")
	public void removePizzaById(@PathVariable long id) {
		pizzaService.deletePizzaById(id);
	}
	
	

	
//Offer*******************************************************************
	
	//add Offer
	@PostMapping("/addoffer")
	public Offer addOffer(@RequestBody Offer offer) {
		offerService.addOffer(offer);
		return offer;
	}
	
	//get offer by id
	@GetMapping("/offer/id/{id}")
	public Optional<Offer> getOfferById(@PathVariable long id) {
		return offerService.findOfferById(id);
	}
	
	//get all offers
	@GetMapping("/showalloffers")
	public List<Offer> getAllOffers() {
		return offerService.findAllOffers();
	}
	
	
	//edit offer
	@PutMapping("/editoffer")
	public Offer editOffer(@RequestBody Offer offer) {
		System.out.println(offer);
		return offerService.updateOffer(offer);
	}
	
	//delete offer
	@DeleteMapping("/deleteoffer/id/{id}")
	public void deleteOfferById(@PathVariable long id) {
		offerService.deleteOfferById(id);
	}
	
	
//Order*******************************************************************
	
	//show all Orders
	@PutMapping("/orders")
	public List<Order> seeAllOrders() {
		return orderService.findAllOrders();
	}
	
	//edit order=> this is not required once the order has been plcaed order can't be changed 
	@PutMapping("/order/editorder")
	public Order editOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
		
	//Deleting users pizza order=> if order is mistakenly placed
	@DeleteMapping("/order/deleteorder/id/{id}")
	public void deleteOrderById(@PathVariable long id) {
		orderService.deleteOrderById(id);
	}
	
	
//Reviews------------------------------------------------------------
	
	//admin can only fetch & delete the reviews
	//user can =>  add reviews & fetch users review by userID & fetch product review by product ID
	
	//get review by id
	@GetMapping("/review/id/{id}")
	public Optional<Review> getReview(@PathVariable long id) {
		return reviewService.getReviewById(id);
	}
	
	//delete review by id
	@DeleteMapping("/deletereview/id/{id}")
	public void deleteReview(@PathVariable long id) {
		 reviewService.deleteReviewById(id);
	}
	
	//get all reviews
	@GetMapping("/allreviews")
	public List<Review> getAllReviews(){
		return reviewService.findAllReviews();
	}
	
}