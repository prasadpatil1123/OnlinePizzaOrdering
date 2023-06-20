package com.pizzaordering.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaordering.model.CartItem;
import com.pizzaordering.model.Order;
import com.pizzaordering.model.ShoppingCart;

@Service
public interface ShoppingCartService {

	// ShoppingCart-----------------------------------------------------

	// add to cart
	public ShoppingCart addToCart(long user_id, long pizza_id);

	// update cart
	public ShoppingCart updateCart(ShoppingCart cart);

	// delete from cart
	public ShoppingCart removeFromCart(long user_id, long pizza_id);

	// get cart by user_id
	public ShoppingCart getCartByUserId(long user_id);

	// Order--------------------------------------------------------------------------------

	// checkout for payment
	public Order checkout(long user_id, long address_id, String paymentType, double discount, double deliveryPrice,
			double taxAmount);

	// Cart
	// Item--------------------------------------------------------------------------------
	// delete cartItem
	public void deleteCartItemById(long id);

	public List<CartItem> getCartItemByCartId(long cart_id);
}
