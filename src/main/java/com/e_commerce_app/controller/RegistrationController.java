package com.e_commerce_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce_app.dto.UserRegistrationDTO;
import com.e_commerce_app.entity.User;
import com.e_commerce_app.service.UserRegistrationService;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO userDto){
		User savedUser = userRegistrationService.registerUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
}
