package com.devcode.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcode.example.exception.ResourceNotFoundException;
import com.devcode.example.model.Product;
import com.devcode.example.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(long id) throws ResourceNotFoundException {
		Optional<Product> prod = productRepository.findById(id);
		
		if(prod.isPresent()) {
			return prod.get();
		}else {
			throw new ResourceNotFoundException("Not Found");
		}
	}

	@Override
	public Product updateProduct(Product p, long id) throws ResourceNotFoundException {
		Product product = productRepository.findById(id).get();
		
		if(product.getId()!=0) {
			product.setProductDescription(p.getProductDescription());
			product.setProductName(p.getProductName());
			product.setProductPrice(p.getProductPrice());
			
			return product;
		}else {
			throw new ResourceNotFoundException("Not Found");
		}
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
		
	}

}
