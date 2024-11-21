package com.e_commerce_app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.e_commerce_app.dto.UserRegistrationDTO;
import com.e_commerce_app.entity.Role;
import com.e_commerce_app.entity.User;
import com.e_commerce_app.repository.RoleRepository;
import com.e_commerce_app.repository.UserRepository;

@Service
public class UserRegistrationService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User registerUser(UserRegistrationDTO userDto) {
		if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
			throw new IllegalArgumentException("Password and Confirm Password doesn't match");
		}
		
		if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
			throw new IllegalArgumentException("Username already exist");
		}
		
		if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email already exist");
		}
		
		Role role = roleRepository.findById(userDto.getRoleId()).get();
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		
		User user = new User();
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		user.setRoles(roles);
		
		return userRepository.save(user);
	}
}
