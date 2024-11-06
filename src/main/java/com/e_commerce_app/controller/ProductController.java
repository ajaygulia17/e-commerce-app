package com.e_commerce_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce_app.entity.Product;
import com.e_commerce_app.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> products = productService.getAllProduct();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.findProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product saved =  productService.saveProduct(product);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
