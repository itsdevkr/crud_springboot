package com.devcode.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcode.example.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
