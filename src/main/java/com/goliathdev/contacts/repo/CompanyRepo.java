package com.goliathdev.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goliathdev.contacts.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Long>{
	
}