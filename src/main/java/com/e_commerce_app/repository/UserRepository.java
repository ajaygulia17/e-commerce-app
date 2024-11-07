package com.e_commerce_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
}
