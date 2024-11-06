package com.e_commerce_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce_app.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
