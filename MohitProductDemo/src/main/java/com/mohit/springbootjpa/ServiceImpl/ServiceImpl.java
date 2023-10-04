package com.mohit.springbootjpa.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.springbootjpa.Repository.ProductRepository;
import com.mohit.springbootjpa.Service.ProductService;
import com.mohit.springbootjpa.model.Product;

@Service
public class ServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository ;
	
	@Override
	public Product createProduct(Product product) {
		
		return repository.save(product);
		
	}

	@Override
	public List<Product> findAllProduct() {
		
		return repository.findAll();
	}

	@Override
	public void delete(int id) {	
		repository.deleteById(id);
		
	}

	@Override
	public Product findById(int id) {
		
		return repository.findById(id).get();
	}

}
