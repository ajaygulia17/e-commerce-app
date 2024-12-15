package com.e_commerce_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce_app.dto.OrderDTO;
import com.e_commerce_app.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<OrderDTO> createOrder(@PathVariable Long userId){
		OrderDTO savedOrder = orderService.createOrder(userId);		
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List> getOrder(@PathVariable Long userId){
		List<OrderDTO> orderList = orderService.getOrderByUserId(userId);
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}
}
