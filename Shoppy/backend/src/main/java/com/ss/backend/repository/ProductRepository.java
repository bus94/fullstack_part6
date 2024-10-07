package com.ss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
