package com.mohit.springbootjpa.Service;

import java.util.List;

import com.mohit.springbootjpa.model.Product;

public interface ProductService {

	public Product createProduct(Product product);
	public List<Product> findAllProduct();
	public Product findById(int id);
	public void delete(int id);
	
	
}
