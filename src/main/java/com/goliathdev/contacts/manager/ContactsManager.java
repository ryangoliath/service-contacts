package com.goliathdev.contacts.manager;

import java.util.List;

import com.goliathdev.contacts.entity.Company;
import com.goliathdev.contacts.entity.Customer;
import com.goliathdev.contacts.entity.Person;
import com.goliathdev.contacts.entity.PhoneNumber;
import com.goliathdev.contacts.entity.Supplier;
import com.goliathdev.contacts.v1.api.model.internal.CompanyType;

public interface ContactsManager {
	
	public Customer findCustomerBy(Long id);
	public Customer save(Customer customer);
	public List<Customer> findAllCustomers();
	public void deleteCustomer(Long id);
	public void deleteCustomer(Customer customer);
	
	public Supplier findSupplierBy(Long id);
	public Supplier save(Supplier supplier);
	public void deleteSupplier(Long id);
	public List<Supplier> findAllSuppliers();
	public void deleteSupplier(Supplier supplier);
	
	public void deleteCompany(CompanyType type, Long id, Long companyId);
	public void deletePerson(CompanyType type, Long id, Long personId);
	public void deletePhoneNumber(CompanyType type, Long id, Long phoneNumberId);
	
	public void updateCompany(CompanyType type, Long id, Long companyId, Company company);
	public void updatePerson(CompanyType type, Long id, Long personId, Person person);
	public void updatePhoneNumber(CompanyType type, Long id, Long phoneNumberId, PhoneNumber phoneNumber);

}
