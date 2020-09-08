package com.goliathdev.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goliathdev.contacts.entity.PhoneNumber;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Long>{
	
}