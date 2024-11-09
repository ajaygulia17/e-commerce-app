package com.e_commerce_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce_app.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
