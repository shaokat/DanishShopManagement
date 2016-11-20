package com.shaokat.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaokat.model.Supplier;
import com.shaokat.repository.SupplierRepository;

@Service
public class SupplierCRUD {
	
	@Autowired
	private SupplierRepository repository;
	
	@Transactional
	public void create(Supplier supplier){
		repository.save(supplier);
	}
	
	public Supplier select(Long id){
		return repository.findOne(id);
		
	}
	@Transactional
	public void update(Supplier updated){
		
		Supplier selected = repository.findOne(updated.getId());
		selected.setName(updated.getName());
		selected.setEmail(updated.getEmail());
		selected.setAddress(updated.getAddress());
		selected.setPhoneNo(updated.getPhoneNo());
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	public List<Supplier> getAllSupplier(){
		return repository.findAll();
	}

}
