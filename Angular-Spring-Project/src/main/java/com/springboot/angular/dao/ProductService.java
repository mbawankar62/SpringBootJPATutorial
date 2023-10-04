package com.springboot.angular.dao;

import java.util.List;

import com.springboot.angular.entity.Product;

public interface ProductService {

	public List<Product> findAll();
}
