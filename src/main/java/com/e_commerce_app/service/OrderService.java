package com.e_commerce_app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce_app.dto.CartDTO;
import com.e_commerce_app.dto.OrderDTO;
import com.e_commerce_app.entity.CartItem;
import com.e_commerce_app.entity.Order;
import com.e_commerce_app.mapper.OrderMapper;
import com.e_commerce_app.repository.OrderRepository;
import com.e_commerce_app.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserRepository userRepository;
	
	public OrderDTO createOrder(Long userId) {
		CartDTO cart = cartService.getCartByUserId(userId);
		
		if (cart==null || cart.getItems().isEmpty()) {
			throw new IllegalArgumentException("Cart is empty or doesn't exist");
		}
		
		BigDecimal totalAmount = cart.getItems().stream()
			.map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		Order order = new Order();
		order.setUser(userRepository.findById(userId).get());
		
		List<CartItem> detachedItems = new ArrayList<>(cart.getItems());
		
		order.setItems(detachedItems);
		order.setOrderDate(new Date());
		order.setTotalAmount(totalAmount);
		order.setStatus(Order.OrderStatus.PENDING);
		
		Order savedOrder = orderRepository.save(order);
		return OrderMapper.toOrderDto(savedOrder);
	}
	
	public List<OrderDTO> getOrderByUserId(Long userId){
		List<Order> orders = orderRepository.findByUserId(userId);
		List<OrderDTO> orderDtos = orders.stream().map((order) -> OrderMapper.toOrderDto(order)).collect(Collectors.toList());
		
		return orderDtos;
	}
}
