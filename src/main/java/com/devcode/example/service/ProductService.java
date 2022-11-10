package com.devcode.example.service;

import java.util.List;

import com.devcode.example.exception.ResourceNotFoundException;
import com.devcode.example.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product p);
	
	public List<Product> getAllProduct();
	
	public Product findProductById(long id) throws ResourceNotFoundException;
	
	public Product updateProduct(Product p, long id) throws ResourceNotFoundException;
	
	public void deleteProduct(long id);
}
