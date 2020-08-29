package com.goliathdev.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goliathdev.contacts.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{
	
}