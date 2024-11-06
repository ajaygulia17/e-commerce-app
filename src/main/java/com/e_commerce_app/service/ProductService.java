package com.e_commerce_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce_app.entity.Product;
import com.e_commerce_app.exception.ResourceNotFoundException;
import com.e_commerce_app.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public Product findProductById(Long id){
		return productRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No Product found with Id: " + id));
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.findById(id).
			orElseThrow(() -> new ResourceNotFoundException("No Product found with Id: " + id));
		productRepository.deleteById(id);
	}
}
