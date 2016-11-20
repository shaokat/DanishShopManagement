package com.shaokat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaokat.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
