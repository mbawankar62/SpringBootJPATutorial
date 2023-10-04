package com.mohit.springbootjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.springbootjpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
