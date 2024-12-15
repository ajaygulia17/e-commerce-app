package com.e_commerce_app.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.e_commerce_app.entity.CartItem;
import com.e_commerce_app.entity.Order.OrderStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OrderDTO {

	private Long Id;
	private UserDTO userDTO;
	private List<CartItem> items;
	private BigDecimal totalAmount;
	private Date orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
