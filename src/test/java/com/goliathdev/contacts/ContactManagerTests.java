package com.goliathdev.contacts;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.goliathdev.contacts.config.JpaTestConfig;
import com.goliathdev.contacts.entity.Company;
import com.goliathdev.contacts.entity.Customer;
import com.goliathdev.contacts.entity.Person;
import com.goliathdev.contacts.entity.PhoneNumber;
import com.goliathdev.contacts.entity.Supplier;
import com.goliathdev.contacts.repo.CompanyRepo;
import com.goliathdev.contacts.repo.CustomerRepo;
import com.goliathdev.contacts.repo.PersonRepo;
import com.goliathdev.contacts.repo.PhoneNumberRepo;
import com.goliathdev.contacts.repo.SupplierRepo;

/**
 * Tests that entities persist correctly.
 * */
@ActiveProfiles("test")
@SpringBootTest(classes = {ServiceContactsApplication.class, JpaTestConfig.class})
class ContactManagerTests {

	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private PhoneNumberRepo phoneNumberRepo;
	
	@Autowired
	private SupplierRepo supplierRepo;

	@Test
	public void companyRepoTest() {
		Company company = new Company();
		company.setName("ABC Corp");
		company.setRegistrationNumber("XYZ-123456789");
		
		companyRepo.save(company);

		assertNotNull(company);
		assertNotNull(company.getId());
	}
	
	@Test
	public void customerRepoTest() {
		Customer customer = new Customer();
		customer.setLastOrderDate(new Date(new java.util.Date().getTime()));
		
		customerRepo.save(customer);

		assertNotNull(customer);
		assertNotNull(customer.getCustomerNumber());
	}
	
	@Test
	public void personRepoTest() {
		Person person = new Person();
		person.setFirstName("Ryan");
		person.setLastName("Goliath");
		
		personRepo.save(person);

		assertNotNull(person);
		assertNotNull(person.getId());
	}
	
	@Test
	public void phoneNumberRepoTest() {
		PhoneNumber number = new PhoneNumber();
		number.setAreaCode("021");
		number.setNumber("9314361");
		
		phoneNumberRepo.save(number);

		assertNotNull(number);
		assertNotNull(number.getId());
	}
	
	@Test
	public void supplierRepoTest() {
		Supplier supplier = new Supplier();
		supplier.setOrderLeadTimeInDays(5);
		supplier.setTaxNumber("12345789");
		
		supplierRepo.save(supplier);

		assertNotNull(supplier);
		assertNotNull(supplier.getId());
	}
}
