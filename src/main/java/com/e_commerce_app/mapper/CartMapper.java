package com.e_commerce_app.mapper;

import com.e_commerce_app.dto.CartDTO;
import com.e_commerce_app.dto.UserDTO;
import com.e_commerce_app.entity.Cart;

public class CartMapper {
	public static CartDTO toCartDto(Cart cart) {
		UserDTO userDto = new UserDTO();
		userDto.setId(cart.getUser().getId());
		userDto.setEmail(cart.getUser().getEmail());
		userDto.setUsername(cart.getUser().getUsername());
		
		return new CartDTO(cart.getId(), cart.getItems(), userDto);
	}
}
