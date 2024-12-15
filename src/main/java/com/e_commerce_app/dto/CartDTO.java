package com.e_commerce_app.dto;

import java.util.List;

import com.e_commerce_app.entity.CartItem;

public class CartDTO {
	private Long id;
	private List<CartItem> items;
	private UserDTO userDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> cartItems) {
		this.items = cartItems;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public CartDTO(Long id, List<CartItem> cartItems, UserDTO userDto) {
		super();
		this.id = id;
		this.items = cartItems;
		this.userDto = userDto;
	}

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
