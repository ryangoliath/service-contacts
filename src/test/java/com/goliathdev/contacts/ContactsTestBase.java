package com.goliathdev.contacts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.goliathdev.contacts.entity.Company;
import com.goliathdev.contacts.entity.Customer;
import com.goliathdev.contacts.entity.Person;
import com.goliathdev.contacts.entity.PhoneNumber;
import com.goliathdev.contacts.entity.Supplier;

public abstract class ContactsTestBase {
	
	protected void assertPhoneNumbers(List<PhoneNumber> phoneNumbers, List<com.goliathdev.contacts.v1.api.model.PhoneNumber> phoneNumbersDto) {
		assertNotNull(phoneNumbers);
		assertNotNull(phoneNumbersDto);
		assertEquals(phoneNumbers.size(), phoneNumbersDto.size());
		
		for (int i = 0; i < phoneNumbersDto.size(); i++) {
			assertEquals(Long.parseLong(phoneNumbersDto.get(i).getId().toString()), phoneNumbers.get(i).getId());
			assertEquals(phoneNumbersDto.get(i).getAreaCode(), phoneNumbers.get(i).getAreaCode());
			assertEquals(phoneNumbersDto.get(i).getNumber(), phoneNumbers.get(i).getNumber());
		}
	}
	
	protected void assertCompany(Company company, com.goliathdev.contacts.v1.api.model.Company companyDto) {
		assertNotNull(company);
		assertNotNull(companyDto);
		assertEquals(Long.parseLong(companyDto.getId().toString()), company.getId());
		assertEquals(companyDto.getName(), company.getName());
		assertEquals(companyDto.getRegistrationNumber(), company.getRegistrationNumber());
	}
	
	protected void assertPerson(Person person, com.goliathdev.contacts.v1.api.model.Person personDto) {
		assertEquals(Long.parseLong(personDto.getId().toString()), person.getId());
		assertEquals(personDto.getFirstName(), person.getFirstName());
		assertEquals(personDto.getLastName(), person.getLastName());
	}
	
	protected void assertCustomer(Customer customer, com.goliathdev.contacts.v1.api.model.Customer customerDto) {
		assertNotNull(customer);
		assertNotNull(customerDto);
		assertEquals(Long.parseLong(customerDto.getCustomerNumber().toString()), customer.getCustomerNumber());
		assertEquals(customerDto.getLastOrderDate(), customer.getLastOrderDate().toString());
	}
	
	protected void assertCustomer(Customer customer, com.goliathdev.contacts.v1.api.model.CustomerDetail customerDto) {
		assertNotNull(customer);
		assertNotNull(customerDto);
		assertEquals(Long.parseLong(customerDto.getCustomerNumber().toString()), customer.getCustomerNumber());
		assertEquals(customerDto.getLastOrderDate(), customer.getLastOrderDate().toString());
	}
	
	protected void assertSupplier(Supplier supplier, com.goliathdev.contacts.v1.api.model.Supplier supplierDto) {
		assertNotNull(supplier);
		assertNotNull(supplierDto);
		assertEquals(Long.parseLong(supplierDto.getId().toString()), supplier.getId());
		assertEquals(supplierDto.getTaxNumber(), supplier.getTaxNumber());
		assertEquals(supplierDto.getOrderLeadTimeInDays(), supplier.getOrderLeadTimeInDays());
	}
	
	/** Reads a test resource file. Does an assertion to ensure that data was read. */
	protected String readResource(String location) {
		String contents = null;
		try {
			contents = new String(IOUtils.toCharArray(this.getClass().getResourceAsStream(location),
					Charset.defaultCharset()));
		} catch (IOException e) {
			e.printStackTrace();
			fail("File not found in location: " + location);
		}
		
		assertNotNull(contents);
		
		return contents;
	}

}
