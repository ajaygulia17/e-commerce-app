package com.e_commerce_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce_app.dto.CartDTO;
import com.e_commerce_app.entity.Cart;
import com.e_commerce_app.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/{userId}")
	public CartDTO getCart(@PathVariable Long userId) {
		return cartService.getCartByUserId(userId);
	}
	
	@PostMapping("/{userId}/add/{productId}/{quantity}")
	public CartDTO addToCart(@PathVariable Long userId,@PathVariable Long productId,@PathVariable int quantity) {
		return cartService.addToCart(userId, productId, quantity);
	}
	
	@DeleteMapping("/{userId}/delete/{cartItemId}")
	public CartDTO deleteFromCart(@PathVariable Long userId,@PathVariable Long cartItemId) {
		return cartService.removeFromCart(userId, cartItemId);
	}
	
	@PutMapping("{userId}/update/{cartItemId}/{quantity}")
	public CartDTO updateQuantity(@PathVariable Long userId,@PathVariable Long cartItemId,@PathVariable int quantity) {
		return cartService.updateCart(userId, cartItemId, quantity);
	}
}
