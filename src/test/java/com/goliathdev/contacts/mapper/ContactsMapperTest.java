package com.goliathdev.contacts.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goliathdev.contacts.ContactsTestBase;
import com.goliathdev.contacts.entity.Customer;
import com.goliathdev.contacts.mappings.ContactsMapper;
import com.goliathdev.contacts.v1.api.model.CustomerDetail;

public class ContactsMapperTest extends ContactsTestBase {

	private ContactsMapper mapper = ContactsMapper.INSTANCE;

	private CustomerDetail customerDetail;

	@Before
	public void config() throws JsonMappingException, JsonProcessingException {
		String json = readResource("/json/contact_customer_persist.json");

		ObjectMapper om = new ObjectMapper();

		// API Model
		customerDetail = om.readValue(json, CustomerDetail.class);
		assertNotNull(customerDetail);

		assertNotNull(customerDetail.getCompany());
		assertNotNull(customerDetail.getPerson());
	}

	@Test
	public void testCustomerMapping() {

		// Mapping to Entity and respective assertions
		Customer customer = mapper.toCustomer(customerDetail);
		assertCustomer(customer, customerDetail);
		assertPerson(customer.getPerson(), customerDetail.getPerson());
		assertPhoneNumbers(customer.getPhoneNumbers(), customerDetail.getPhoneNumbers());

	}

//	@Test
//	public void testSupplierMapping() {
//
//		// Mapping to Entity and respective assertions
//		Supplier supplier = mapper.toSupplier(contactItem);
//		assertSupplier(supplier, contactItem.getSupplier());
//		assertCompany(supplier.getCompany(), contactItem.getSupplier().getCompany());
//		assertPerson(supplier.getPerson(), contactItem.getSupplier().getPerson());
//		assertPhoneNumbers(supplier.getPhoneNumbers(), contactItem.getSupplier().getPhoneNumbers());
//
//	}

}
