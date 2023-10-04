package com.springboot.angular.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.angular.entity.Product;

@Service
public class ProductImpl implements ProductService{

	private ProductRepository productRepository;
	
	public ProductImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

}
