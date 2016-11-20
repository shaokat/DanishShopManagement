package com.shaokat.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaokat.model.Product;
import com.shaokat.repository.ProductRepository;

@Service
public class ProductCRUD {
	
	@Autowired 
	private ProductRepository repository;
	
	@Transactional
	public void create(Product product){
		repository.save(product);
	}
	
	public Product select(Long id){
		return repository.findOne(id);
	
	}
	@Transactional
	public void update(Product updated){
		
		Product selected = repository.findOne(updated.getId());
		
		selected.setName(updated.getName());
		selected.setpType(updated.getpType());
	}
	public void delete(Long id){
		repository.delete(id);
	}
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
}
