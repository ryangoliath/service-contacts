package com.goliathdev.contacts.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import com.goliathdev.contacts.v1.api.model.internal.CompanyType;

/**
 * Provides persistence layer to the REST interface.
 */
@Component
public class ContactsManagerImpl implements ContactsManager {

	private static final Logger logger = LoggerFactory.getLogger(ContactsManagerImpl.class);

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private SupplierRepo supplierRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private PhoneNumberRepo phoneNumberRepo;

	@Override
	@Transactional
	public Customer save(Customer customer) {
		Customer response = null;
		try {
			response = customerRepo.save(customer);
		} catch (Exception e) {
			logger.error("Error saving customer.", e);
		}
		return response;
	}

	@Override
	@Transactional
	public Supplier save(Supplier supplier) {
		Supplier response = null;
		try {
			response = supplierRepo.save(supplier);
		} catch (Exception e) {
			logger.error("Error saving supplier.", e);
		}
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findCustomerBy(Long id) {
		return customerRepo.findByCustomerNumber(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Supplier findSupplierBy(Long id) {
		return supplierRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Supplier> findAllSuppliers() {
		return supplierRepo.findAll();
	}

	@Override
	@Transactional
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
	}

	@Override
	@Transactional
	public void deleteSupplier(Long id) {
		supplierRepo.deleteById(id);
	}
	
	@Override
	@Transactional
	public void deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

	/** Deletes a company. Requires an id linked to the current customer, to enforce integrity*/
	@Override
	@Transactional
	public void deleteCompany(CompanyType type, Long id, Long companyId) {
		switch (type) {
		case CUSTOMER:
			Customer customer = findCustomerBy(id);
			if(customer == null) {
				throw new IllegalArgumentException("Customer not found.");
			}
			
			if(customer.getCompany() != null && customer.getCompany().getId().equals(companyId)) {
				companyRepo.deleteById(companyId);
			} else {
				throw new IllegalArgumentException("Company cannot be deleted, as it is not linked to Customer [" + id + "].");
			}
			
			break;
		case SUPPLIER:
			Supplier supplier = findSupplierBy(id);
			if(supplier == null) {
				throw new IllegalArgumentException("Supplier not found.");
			}
			
			if(supplier.getCompany() != null && supplier.getCompany().getId().equals(companyId)) {
				companyRepo.deleteById(companyId);
			} else {
				throw new IllegalArgumentException("Company cannot be deleted, as it is not linked to Supplier [" + id + "].");
			}

			break;
		default:
			break;
		}
	}
	
	@Override
	@Transactional
	public void deletePerson(CompanyType type, Long id, Long personId) {
		switch (type) {
		case CUSTOMER:
			Customer customer = findCustomerBy(id);
			if(customer == null) {
				throw new IllegalArgumentException("Customer not found.");
			}
			
			if(customer.getPerson() != null && customer.getPerson().getId().equals(personId)) {
				personRepo.deleteById(personId);
			} else {
				throw new IllegalArgumentException("Person cannot be deleted, as it is not linked to Customer [" + id + "].");
			}
			
			break;
		case SUPPLIER:
			Supplier supplier = findSupplierBy(id);
			if(supplier == null) {
				throw new IllegalArgumentException("Supplier not found.");
			}
			
			if(supplier.getPerson() != null && supplier.getPerson().getId().equals(personId)) {
				personRepo.deleteById(personId);
			} else {
				throw new IllegalArgumentException("Person cannot be deleted, as it is not linked to Supplier [" + id + "].");
			}

			break;
		default:
			break;
		}
	}

	@Override
	public void deletePhoneNumber(CompanyType type, Long id, Long phoneNumberId) {
		switch (type) {
		case CUSTOMER:
			Customer customer = findCustomerBy(id);
			if(customer == null) {
				throw new IllegalArgumentException("Customer not found.");
			}
			
			customer.getPhoneNumbers().removeIf(phoneNumber -> phoneNumber.getId().equals(phoneNumberId));
			
			break;
		case SUPPLIER:
			Supplier supplier = findSupplierBy(id);
			if(supplier == null) {
				throw new IllegalArgumentException("Supplier not found.");
			}
			
			supplier.getPhoneNumbers().removeIf(phoneNumber -> phoneNumber.getId().equals(phoneNumberId));

			break;
		default:
			break;
		}
	}

	@Override
	public void updateCompany(CompanyType type, Long id, Long companyId, Company company) {
		switch (type) {
		case CUSTOMER:
			Customer customer = findCustomerBy(id);
			if(customer == null) {
				throw new IllegalArgumentException("Customer not found.");
			}
			
			if(customer.getCompany() != null && customer.getCompany().getId().equals(companyId)) {
				company.setId(companyId);
				companyRepo.save(company);
			} else {
				throw new IllegalArgumentException("Company cannot be updated, as it is not linked to Customer [" + id + "].");
			}
			
			break;
		case SUPPLIER:
			Supplier supplier = findSupplierBy(id);
			if(supplier == null) {
				throw new IllegalArgumentException("Supplier not found.");
			}
			
			if(supplier.getCompany() != null && supplier.getCompany().getId().equals(companyId)) {
				company.setId(companyId);
				companyRepo.save(company);
			} else {
				throw new IllegalArgumentException("Company cannot be updated, as it is not linked to Customer [" + id + "].");
			}

			break;
		default:
			break;
		}
	}

	@Override
	public void updatePerson(CompanyType type, Long id, Long personId, Person person) {
		switch (type) {
		case CUSTOMER:
			Customer customer = findCustomerBy(id);
			if(customer == null) {
				throw new IllegalArgumentException("Customer not found.");
			}
			
			if(customer.getPerson() != null && customer.getPerson().getId().equals(personId)) {
				person.setId(personId);
				personRepo.save(person);
			} else {
				throw new IllegalArgumentException("Person cannot be updated, as it is not linked to Customer [" + id + "].");
			}
			
			break;
		case SUPPLIER:
			Supplier supplier = findSupplierBy(id);
			if(supplier == null) {
				throw new IllegalArgumentException("Supplier not found.");
			}
			
			if(supplier.getPerson() != null && supplier.getPerson().getId().equals(personId)) {
				person.setId(personId);
				personRepo.save(person);
			} else {
				throw new IllegalArgumentException("Person cannot be updated, as it is not linked to Customer [" + id + "].");
			}

			break;
		default:
			break;
		}
	}

	@Override
	public void updatePhoneNumber(CompanyType type, Long id, Long phoneNumberId, PhoneNumber phoneNumber) {
		switch (type) {
		case CUSTOMER:
			Customer customer = findCustomerBy(id);
			if(customer == null) {
				throw new IllegalArgumentException("Customer not found.");
			}
			
			customer.getPhoneNumbers().stream().forEach(phoneNum -> {
				if(phoneNum.getId().equals(phoneNumberId)) {
					phoneNumber.setId(phoneNumberId);
					phoneNumberRepo.save(phoneNumber);
				}
			});
			
			break;
		case SUPPLIER:
			Supplier supplier = findSupplierBy(id);
			if(supplier == null) {
				throw new IllegalArgumentException("Supplier not found.");
			}
			
			supplier.getPhoneNumbers().stream().forEach(phoneNum -> {
				if(phoneNum.getId().equals(phoneNumberId)) {
					phoneNumber.setId(phoneNumberId);
					phoneNumberRepo.save(phoneNumber);
				}
			});

			break;
		default:
			break;
		}
	}

}
