package com.goliathdev.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goliathdev.contacts.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long>{
	
}