package com.shaokat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaokat.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
