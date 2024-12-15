package com.e_commerce_app.mapper;

import com.e_commerce_app.dto.OrderDTO;
import com.e_commerce_app.dto.UserDTO;
import com.e_commerce_app.entity.Order;

public class OrderMapper {

	public static OrderDTO toOrderDto(Order order) {
		UserDTO userDto = UserMapper.toUserDto(order.getUser());
		OrderDTO orderDto = new OrderDTO();
		
		orderDto.setId(order.getId());
		orderDto.setItems(order.getItems());
		orderDto.setOrderDate(order.getOrderDate());
		orderDto.setStatus(order.getStatus());
		orderDto.setTotalAmount(order.getTotalAmount());
		orderDto.setUserDTO(userDto);
		
		return orderDto;
	}
}
