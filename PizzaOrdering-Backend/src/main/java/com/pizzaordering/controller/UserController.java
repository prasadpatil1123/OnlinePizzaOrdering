package com.pizzaordering.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaordering.dao.OrderItemDao;
import com.pizzaordering.exception.ResourceNotFoundException;
import com.pizzaordering.model.Address;
import com.pizzaordering.model.CartItem;
import com.pizzaordering.model.Order;
import com.pizzaordering.model.Pizza;
import com.pizzaordering.model.Review;
import com.pizzaordering.model.ShoppingCart;
import com.pizzaordering.model.Users;
import com.pizzaordering.services.AddressService;
import com.pizzaordering.services.OrderService;
import com.pizzaordering.services.PizzaService;
import com.pizzaordering.services.ReviewService;
import com.pizzaordering.services.ShoppingCartService;
import com.pizzaordering.services.UsersService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UsersService usersService;

	@Autowired
	AddressService addressService;

	@Autowired
	PizzaService pizzaService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemDao orderItemDao;

	// user registration ==> that can be customer,admin,deliveryBoy
	@PostMapping("/register") // go to postman and post new user data in JSON format to register
	public Users register(@RequestBody Users users) {
		return usersService.addUsers(users);
	}

	// user login ==> that can be customer,admin,deliveryboy
	@PostMapping("/login")
	ResponseEntity<Users> loginCustomer(@RequestParam String email, @RequestParam String password) {
		Users users1 = this.usersService.login(email, password);
		return ResponseEntity.status(HttpStatus.OK).body(users1);
	}

	// fetch user by id
	@GetMapping("/getallusers")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}

	// update/edit user credential
	@PutMapping("/editusersinfo")
	Users updateUser(@RequestBody Users users) {
		return usersService.editUser(users);
	}

	// delete?remove user from DB
	@DeleteMapping("/removeuser/id/{id}")
	Users removeUser(@PathVariable long id) {
		return usersService.deleteUsers(id);
	}

	// Address---------------------------------------------------------------------------------------------------------

	@PostMapping("/address")
	public Address addAddress(@RequestBody Address address) {
		this.addressService.addAddress(address);
		return address;
	}

	@GetMapping("/addresses")
	public List<Address> seeAllAddress() {
		return this.addressService.findAllAddress();
	}

	@GetMapping("addressbyuser/id/{id}")
	public List<Address> getAddressByUser(@PathVariable long id) {
		return this.addressService.getAddressByUsers(id);
	}

	@DeleteMapping("/address/id/{id}")
	public void deleteAddressUserById(@PathVariable long id) {
		addressService.deleteAddresssById(id);
	}

	// Updating or Editing user address..................
	@PutMapping("/edituseraddress/id/{id}")
	public Address updateAddress(@RequestBody Address address) {
		return addressService.editUsersAddress(address);
	}

	// Pizza Home Page or handle by
	// customer------------------------------------------------------

	// show all pizza on home page
	@GetMapping("/Pizzas")
	public List<Pizza> getAllPizza() {
		return this.pizzaService.findAllPizza();
	}

	// show pizzas by category
	@GetMapping("/pizzabycat/id/{id}")
	public List<Pizza> getPizzaByCatId(@PathVariable long id) {
		return pizzaService.findByCategoryId(id);
	}

	@GetMapping("/pizza/id/{id}")
	public Pizza getPizzaById(@PathVariable long id) {
		return pizzaService.PizzaById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id, Please enter valid id."));
	}

	// ShoppingCart------------------------------------------------------------------

	// add to cart
	@PostMapping("/addtocart")
	public ShoppingCart addToCart(@RequestParam("userId") long userId, @RequestParam("pizzaId") long pizzaId) {
		return shoppingCartService.addToCart(userId, pizzaId);
	}

	// remove Item from cart
	@DeleteMapping("/removefromcart")
	public ShoppingCart removeFromCart(@RequestParam("userId") long userId, @RequestParam("pizzaId") long pizzaId) {
		return shoppingCartService.removeFromCart(userId, pizzaId);
	}

	// checkout
	@PostMapping("/checkout")
	public Order checkout(@RequestBody Order order) {
		return shoppingCartService.checkout(order.getCartOwner().getId(), order.getAddress().getId(),
				order.getPaymentType(), order.getDiscount(), order.getDeliveryPrice(), order.getTaxAmount());
	}

	// getCartByUserId
	@GetMapping("/carts/user-id/{user_id}")
	public ShoppingCart getCartByUserId(@PathVariable long user_id) {
		return shoppingCartService.getCartByUserId(user_id);
	}

	// CartItems--------------------------------------------

	// getCartItemsByCartId
	@GetMapping("/cartitems/cartId/{cart_id}")
	public List<CartItem> getCartItemsByCartId(@PathVariable long cart_id) {
		return shoppingCartService.getCartItemByCartId(cart_id);
	}

	@DeleteMapping("/deletecartitem/id/{id}")
	public void deleteCartItemById(@PathVariable long id) {
		shoppingCartService.deleteCartItemById(id);
	}
	// Review------------------------------------------------------------

	// Order & Review => once you place the order then you are applicable to provide
	// a Review--------------------------------------------------------
	// Order ------

	// add order
	@PostMapping("/placeorder")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	// get order by orderID
	@GetMapping("/order/id/{id}")
	public Optional<Order> getOrderById(@PathVariable long id) {
		return orderService.findOrderById(id);
	}

	// get order by userID
	@GetMapping("/orderbyuser/id/{id}")
	public Order getorderByUserId(@PathVariable long id) {
		return orderService.findOrderByUserId(id);
	}

	// find orderItem by orderID
	@GetMapping("/orderitembyorder/id/{id}")
	public Order findOrderItemsByOrder(@PathVariable long id) {
		return orderItemDao.findByOrderId(id);
	}

	// add review
	@PostMapping("/review")
	public Review addReview(@RequestBody Review review) {
		reviewService.addReview(review);
		return review;
	}

	// get user review by user id
	@GetMapping("/userreviews/id/{id}")
	public List<Review> getUserReviews(@PathVariable long id) {
		return reviewService.findReviewByUsersId(id);
	}

	// get product review by product id
	@GetMapping("/productreview/id/{id}")
	public List<Review> getProductReviews(@PathVariable long id) {
		return reviewService.findReviewByProduct(id);
	}
}
