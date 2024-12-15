package com.e_commerce_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce_app.dto.CartDTO;
import com.e_commerce_app.dto.UserDTO;
import com.e_commerce_app.entity.Cart;
import com.e_commerce_app.entity.CartItem;
import com.e_commerce_app.entity.Product;
import com.e_commerce_app.mapper.CartMapper;
import com.e_commerce_app.repository.CartItemRepository;
import com.e_commerce_app.repository.CartRepository;
import com.e_commerce_app.repository.UserRepository;

@Service
public class CartService {
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserRepository userRepository;
	
	public CartDTO getCartByUserId(Long userId) {
		Cart cart =  cartRepository.findByUserId(userId);
		return CartMapper.toCartDto(cart);
		
	}
	
	public CartDTO addToCart(Long userId, Long productId, int quantity) {
		
		Cart cart = cartRepository.findByUserId(userId);
		if (cart==null) {
			cart = new Cart();
			cart.setUser(userRepository.findById(userId).get());
		}
		
		Product product =  productService.findProductById(productId);

		Boolean condition = false;
		for (int i=0; i<cart.getItems().size(); i++) {
			
			if (cart.getItems().get(i).getProduct()==product) {
				condition=true;
			}
		}
		
		if (condition) {
			List<CartItem> requiredcartItems = cart.getItems().stream().filter((cartItem) -> {
				return cartItem.getProduct() == product;
				}
			).collect(Collectors.toList());
			
			return this.updateCart(userId, requiredcartItems.get(0).getId(), quantity);
		}
		
		if (product.getStock()>=quantity){
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setQuantity(quantity);
			cart.getItems().add(item);
			cartItemRepository.save(item);
			cart = cartRepository.save(cart);
		}		
		
		
		return CartMapper.toCartDto(cart);
	}
	
	public CartDTO removeFromCart(Long userId, Long CartItemId) {
		Cart cart = cartRepository.findByUserId(userId);
		cart.getItems().removeIf(cartItem -> cartItem.getId().equals(CartItemId));
		Cart updatedCart = cartRepository.save(cart);
		return CartMapper.toCartDto(updatedCart);
	}
	
	public CartDTO updateCart(Long userId, Long cartItemId, int quantity) {
		Cart cart = cartRepository.findByUserId(userId);
		if (cart!=null) {
			cart.getItems().forEach(cartItem -> {
				
			if (cartItem.getId().equals(cartItemId)){
				cartItem.setQuantity(quantity);
				cartItemRepository.save(cartItem);
			}
			});
			cart = cartRepository.save(cart);
		}
		return CartMapper.toCartDto(cart);
	}
}
