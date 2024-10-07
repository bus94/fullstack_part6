package com.ss.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.backend.entity.Product;
import com.ss.backend.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductRepository productReposit;

	// 모든 상품 불러오기
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productReposit.findAll();
	}
	
	// 상품 등록하기
	@Transactional
	public Product save(Product product) {
		return productReposit.save(product);
	}
}
