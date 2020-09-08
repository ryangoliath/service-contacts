package com.goliathdev.contacts.v1.worker;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.goliathdev.contacts.entity.rule.Validator;
import com.goliathdev.contacts.manager.ContactsManager;
import com.goliathdev.contacts.mappings.ContactsMapper;
import com.goliathdev.contacts.v1.api.V1Api;
import com.goliathdev.contacts.v1.api.model.Company;
import com.goliathdev.contacts.v1.api.model.Customer;
import com.goliathdev.contacts.v1.api.model.CustomerDetail;
import com.goliathdev.contacts.v1.api.model.Error;
import com.goliathdev.contacts.v1.api.model.Person;
import com.goliathdev.contacts.v1.api.model.PhoneNumber;
import com.goliathdev.contacts.v1.api.model.Supplier;
import com.goliathdev.contacts.v1.api.model.SupplierDetail;
import com.goliathdev.contacts.v1.api.model.internal.CompanyType;
import com.goliathdev.contacts.v1.rest.error.StatusCode;

@Component
public class V1Worker implements V1Api {
	
	private static final Logger logger = LoggerFactory.getLogger(V1Worker.class);
	
	private ContactsMapper mapper = ContactsMapper.INSTANCE;

	@Autowired
	private Validator validator;

	@Autowired
	private ContactsManager contactsManager;

	@Override
	public ResponseEntity<CustomerDetail> addCustomer(Principal principal, @Valid CustomerDetail customer)
			throws Exception {
		
		com.goliathdev.contacts.entity.Customer customerEntity = mapper.toCustomer(customer);

		if (!validator.isValid(customerEntity)) {
			logger.warn(StatusCode.ERROR_CUSTOMER_400.getDescription());
			customer.setError(getError(StatusCode.ERROR_CUSTOMER_400));
			return new ResponseEntity<com.goliathdev.contacts.v1.api.model.CustomerDetail>(customer, StatusCode.ERROR_CUSTOMER_400.getHttpStatus());
		}

		customerEntity = contactsManager.save(customerEntity);

		if (customerEntity == null) {
			return new ResponseEntity<com.goliathdev.contacts.v1.api.model.CustomerDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		customer = mapper.toCustomerDetail(customerEntity);

		return new ResponseEntity<com.goliathdev.contacts.v1.api.model.CustomerDetail>(customer, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<SupplierDetail> addSupplier(Principal principal, @Valid SupplierDetail customer)
			throws Exception {
		
		com.goliathdev.contacts.entity.Supplier supplierEntity = mapper.toSupplier(customer);

		if (!validator.isValid(supplierEntity)) {
			logger.warn(StatusCode.ERROR_SUPPLIER_400.getDescription());
			customer.setError(getError(StatusCode.ERROR_SUPPLIER_400));
			return new ResponseEntity<com.goliathdev.contacts.v1.api.model.SupplierDetail>(customer, StatusCode.ERROR_SUPPLIER_400.getHttpStatus());
		}

		supplierEntity = contactsManager.save(supplierEntity);

		if (supplierEntity == null) {
			return new ResponseEntity<com.goliathdev.contacts.v1.api.model.SupplierDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		customer = mapper.toSupplierDetail(supplierEntity);

		return new ResponseEntity<com.goliathdev.contacts.v1.api.model.SupplierDetail>(customer, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteCustomer(Principal principal, Integer id) throws Exception {
		try {
			
			com.goliathdev.contacts.entity.Customer customer = contactsManager.findCustomerBy(new Long(id));
			
			if(customer == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			contactsManager.deleteCustomer(customer);
			
		} catch(Exception e) {
			logger.warn("Customer [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCustomerCompany(Principal principal, Integer customerId, Integer id)
			throws Exception {
		try {
			
			contactsManager.deleteCompany(CompanyType.CUSTOMER, new Long(customerId), new Long(id));
			
		} catch(IllegalArgumentException e) {
			logger.warn("Company [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCustomerPerson(Principal principal, Integer customerId, Integer id)
			throws Exception {
		try {
			
			contactsManager.deletePerson(CompanyType.CUSTOMER, new Long(customerId), new Long(id));
			
		} catch(IllegalArgumentException e) {
			logger.warn("Person [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCustomerPhoneNumber(Principal principal, Integer customerId, Integer id)
			throws Exception {
		try {
			
			contactsManager.deletePhoneNumber(CompanyType.CUSTOMER, new Long(customerId), new Long(id));
			
		} catch(IllegalArgumentException e) {
			logger.warn("Person [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteSupplier(Principal principal, Integer id) throws Exception {
		try {
			
			com.goliathdev.contacts.entity.Supplier supplier = contactsManager.findSupplierBy(new Long(id));
			
			if(supplier == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			contactsManager.deleteSupplier(supplier);
			
		} catch(Exception e) {
			logger.warn("Supplier [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteSupplierCompany(Principal principal, Integer supplierId, Integer id)
			throws Exception {
		try {
			
			contactsManager.deleteCompany(CompanyType.SUPPLIER, new Long(supplierId), new Long(id));
			
		} catch(IllegalArgumentException e) {
			logger.warn("Company [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteSupplierPerson(Principal principal, Integer supplierId, Integer id)
			throws Exception {
		try {
			
			contactsManager.deletePerson(CompanyType.SUPPLIER, new Long(supplierId), new Long(id));
			
		} catch(IllegalArgumentException e) {
			logger.warn("Person [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteSupplierPhoneNumber(Principal principal, Integer supplierId, Integer id)
			throws Exception {
		try {
			
			contactsManager.deletePhoneNumber(CompanyType.SUPPLIER, new Long(supplierId), new Long(id));
			
		} catch(IllegalArgumentException e) {
			logger.warn("Person [{}] not deleted.", id, e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CustomerDetail> getCustomer(Principal principal, Integer id) throws Exception {
		
		CustomerDetail response = null;

		com.goliathdev.contacts.entity.Customer customer = contactsManager.findCustomerBy(new Long(id));

		if (customer == null) {
			logger.warn(StatusCode.ERROR_CUSTOMER_404.getDescription());
			return new ResponseEntity<CustomerDetail>(HttpStatus.NOT_FOUND);
		}

		// Map all customer to rest api customerdetail model
		response = mapper.toCustomerDetail(customer);

		return new ResponseEntity<CustomerDetail>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CustomerDetail>> getCustomers(Principal principal) throws Exception {

		List<CustomerDetail> response = null;

		List<com.goliathdev.contacts.entity.Customer> customerEntities = contactsManager.findAllCustomers();

		if (CollectionUtils.isEmpty(customerEntities)) {
			logger.warn(StatusCode.ERROR_CUSTOMER_404.getDescription());
			return new ResponseEntity<List<CustomerDetail>>(HttpStatus.NOT_FOUND);
		}

		// Map all customers to rest api customerdetail models
		response = customerEntities.stream().map(customer -> mapper.toCustomerDetail(customer)).collect(Collectors.toList());
		
		return new ResponseEntity<List<CustomerDetail>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SupplierDetail> getSupplier(Principal principal, Integer id) throws Exception {
		
		SupplierDetail response = null;

		com.goliathdev.contacts.entity.Supplier supplier = contactsManager.findSupplierBy(new Long(id));

		if (supplier == null) {
			logger.warn(StatusCode.ERROR_SUPPLIER_404.getDescription());
			return new ResponseEntity<SupplierDetail>(HttpStatus.NOT_FOUND);
		}

		// Map supplier to rest api supplierdetail model
		response = mapper.toSupplierDetail(supplier);

		return new ResponseEntity<SupplierDetail>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<SupplierDetail>> getSuppliers(Principal principal) throws Exception {

		List<SupplierDetail> response = null;

		List<com.goliathdev.contacts.entity.Supplier> supplierEntities = contactsManager.findAllSuppliers();

		if (CollectionUtils.isEmpty(supplierEntities)) {
			logger.warn(StatusCode.ERROR_SUPPLIER_404.getDescription());
			return new ResponseEntity<List<SupplierDetail>>(HttpStatus.NOT_FOUND);
		}

		// Map all suppliers to rest api supplierdetail models
		response = supplierEntities.stream().map(supplier -> mapper.toSupplierDetail(supplier)).collect(Collectors.toList());

		return new ResponseEntity<List<SupplierDetail>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Principal principal, Integer id, @Valid Customer customer)
			throws Exception {
		
		Customer response = null;

		com.goliathdev.contacts.entity.Customer customerEntity = contactsManager.findCustomerBy(new Long(id));

		if (customerEntity == null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
		}
		
		// partial update
		com.goliathdev.contacts.entity.Customer mappedEntity = mapper.toCustomer(customer);
		customerEntity.setLastOrderDate(mappedEntity.getLastOrderDate());
		contactsManager.save(customerEntity);
		
		// map to dto
		response = mapper.toCustomer(customerEntity);

		return new ResponseEntity<Customer>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Company> updateCustomerCompany(Principal principal, Integer customerId, Integer id,
			@Valid Company company) throws Exception {
		
		com.goliathdev.contacts.entity.Company companyEntity = mapper.toCompany(company);
		
		if (companyEntity == null) {
			return new ResponseEntity<Company>(company, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			contactsManager.updateCompany(CompanyType.CUSTOMER, new Long(customerId), new Long(id), companyEntity);
			
		} catch(IllegalArgumentException e) {
			logger.warn("Company [{}] not updated.", id, e);
			return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
		}
		
		// map to dto
		Company response = mapper.toCompany(companyEntity);

		return new ResponseEntity<Company>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Person> updateCustomerPerson(Principal principal, Integer customerId, Integer id,
			@Valid Person person) throws Exception {
		
		com.goliathdev.contacts.entity.Person personEntity = mapper.toPerson(person);
		
		if (personEntity == null) {
			return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			contactsManager.updatePerson(CompanyType.CUSTOMER, new Long(customerId), new Long(id), personEntity);
			
		} catch(IllegalArgumentException e) {
			logger.warn("Person [{}] not updated.", id, e);
			return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
		}
		
		// map to dto
		Person response = mapper.toPerson(personEntity);

		return new ResponseEntity<Person>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PhoneNumber> updateCustomerPhoneNumber(Principal principal, Integer customerId, Integer id,
			@Valid PhoneNumber phoneNumber) throws Exception {
		
		com.goliathdev.contacts.entity.PhoneNumber phoneNumberEntity = mapper.toPhoneNumber(phoneNumber);
		
		if (phoneNumberEntity == null) {
			return new ResponseEntity<PhoneNumber>(phoneNumber, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			contactsManager.updatePhoneNumber(CompanyType.CUSTOMER, new Long(customerId), new Long(id), phoneNumberEntity);
			
		} catch(IllegalArgumentException e) {
			logger.warn("PhoneNumber [{}] not updated.", id, e);
			return new ResponseEntity<PhoneNumber>(phoneNumber, HttpStatus.BAD_REQUEST);
		}
		
		// map to dto
		PhoneNumber response = mapper.toPhoneNumber(phoneNumberEntity);

		return new ResponseEntity<PhoneNumber>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Supplier> updateSupplier(Principal principal, Integer id, @Valid Supplier supplier)
			throws Exception {
		
		Supplier response = null;

		com.goliathdev.contacts.entity.Supplier supplierEntity = contactsManager.findSupplierBy(new Long(id));

		if (supplierEntity == null) {
			return new ResponseEntity<Supplier>(supplier, HttpStatus.NOT_FOUND);
		}
		
		// partial update
		com.goliathdev.contacts.entity.Supplier mappedEntity = mapper.toSupplier(supplier);
		supplierEntity.setOrderLeadTimeInDays(mappedEntity.getOrderLeadTimeInDays());
		supplierEntity.setTaxNumber(mappedEntity.getTaxNumber());
		contactsManager.save(supplierEntity);
		
		// map to dto
		response = mapper.toSupplier(supplierEntity);

		return new ResponseEntity<Supplier>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Company> updateSupplierCompany(Principal principal, Integer supplierId, Integer id,
			@Valid Company company) throws Exception {
		
		com.goliathdev.contacts.entity.Company companyEntity = mapper.toCompany(company);
		
		if (companyEntity == null) {
			return new ResponseEntity<Company>(company, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			contactsManager.updateCompany(CompanyType.SUPPLIER, new Long(supplierId), new Long(id), companyEntity);
			
		} catch(IllegalArgumentException e) {
			logger.warn("Company [{}] not updated.", id, e);
			return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
		}
		
		// map to dto
		Company response = mapper.toCompany(companyEntity);

		return new ResponseEntity<Company>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Person> updateSupplierPerson(Principal principal, Integer supplierId, Integer id,
			@Valid Person person) throws Exception {
		
		com.goliathdev.contacts.entity.Person personEntity = mapper.toPerson(person);
		
		if (personEntity == null) {
			return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			contactsManager.updatePerson(CompanyType.SUPPLIER, new Long(supplierId), new Long(id), personEntity);
			
		} catch(IllegalArgumentException e) {
			logger.warn("Person [{}] not updated.", id, e);
			return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
		}
		
		// map to dto
		Person response = mapper.toPerson(personEntity);

		return new ResponseEntity<Person>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PhoneNumber> updateSupplierPhoneNumber(Principal principal, Integer supplierId, Integer id,
			@Valid PhoneNumber phoneNumber) throws Exception {
		
		com.goliathdev.contacts.entity.PhoneNumber phoneNumberEntity = mapper.toPhoneNumber(phoneNumber);
		
		if (phoneNumberEntity == null) {
			return new ResponseEntity<PhoneNumber>(phoneNumber, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			contactsManager.updatePhoneNumber(CompanyType.SUPPLIER, new Long(supplierId), new Long(id), phoneNumberEntity);
			
		} catch(IllegalArgumentException e) {
			logger.warn("PhoneNumber [{}] not updated.", id, e);
			return new ResponseEntity<PhoneNumber>(phoneNumber, HttpStatus.BAD_REQUEST);
		}
		
		// map to dto
		PhoneNumber response = mapper.toPhoneNumber(phoneNumberEntity);

		return new ResponseEntity<PhoneNumber>(response, HttpStatus.OK);
	}
	
	private Error getError(StatusCode statusCode) {
		return new Error(statusCode.getDescription(), statusCode.getHttpStatus().value());
	}

}
