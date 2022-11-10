package com.devcode.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcode.example.exception.ResourceNotFoundException;
import com.devcode.example.model.Product;
import com.devcode.example.service.ProductServiceImpl;

@RestController
@RequestMapping("/restapi/products")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product p){
		
		Product myProduct = productServiceImpl.saveProduct(p);
		return new ResponseEntity<Product>(myProduct, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> allProduct = productServiceImpl.getAllProduct();
		return new ResponseEntity<List<Product>>(allProduct,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ResourceNotFoundException{
		Product prod = productServiceImpl.findProductById(productId);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product p, @PathVariable("id") long productId) throws ResourceNotFoundException{
		Product updatedProduct = productServiceImpl.updateProduct(p, productId);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") long productId){
		productServiceImpl.deleteProduct(productId);
		return new ResponseEntity<String>("Deleted!!", HttpStatus.OK);
	}
}
