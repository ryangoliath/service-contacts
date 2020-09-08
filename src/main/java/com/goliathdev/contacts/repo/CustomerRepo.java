package com.goliathdev.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goliathdev.contacts.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	public Customer findByCustomerNumber(Long customerNumber);
	
}