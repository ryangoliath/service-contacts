package com.goliathdev.contacts.v1.api;

import com.goliathdev.contacts.v1.api.model.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.*;

import java.util.List;
import java.security.Principal;
import javax.annotation.Generated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

/**
 * Simple Contacts API
 * This is a simple Contacts storage API
 *
 * T&Cs: 
 * NOTE: The context path of your deployment must be "/ryangoliath/service-contacts/1.0.0".
 *
 * @version 1.0.0
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
public interface V1Api { 

	/**
	 * Adds a Customer contact to the system
	 *
	 * @param principal
	 * @param customer
	 * @return
	 *         201 (Customer contact created)
	 *         400 (invalid input, object invalid)
	 *         409 (Customer contact already exists)
	 */
	ResponseEntity<CustomerDetail> addCustomer(Principal principal, @Valid @RequestBody CustomerDetail customer) throws Exception;

	/**
	 * Adds a Supplier contact to the system
	 *
	 * @param principal
	 * @param customer
	 * @return
	 *         201 (Supplier contact created)
	 *         400 (invalid input, object invalid)
	 *         409 (Supplier contact already exists)
	 */
	ResponseEntity<SupplierDetail> addSupplier(Principal principal, @Valid @RequestBody SupplierDetail customer) throws Exception;

	/**
	 * Deletes a Customer contact in the system, as well as associating details
	 *
	 * @param principal
	 * @param id
	 * @return
	 *         200 (Customer contact deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteCustomer(Principal principal, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a Company in the system
	 *
	 * @param principal
	 * @param customerId
	 * @param id
	 * @return
	 *         200 (Company deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteCustomerCompany(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a Person in the system
	 *
	 * @param principal
	 * @param customerId
	 * @param id
	 * @return
	 *         200 (Person deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteCustomerPerson(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a PhoneNumber in the system
	 *
	 * @param principal
	 * @param customerId
	 * @param id
	 * @return
	 *         200 (PhoneNumber deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteCustomerPhoneNumber(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a Supplier contact in the system, as well as associating details
	 *
	 * @param principal
	 * @param id
	 * @return
	 *         200 (Supplier contact deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteSupplier(Principal principal, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a Company in the system
	 *
	 * @param principal
	 * @param supplierId
	 * @param id
	 * @return
	 *         200 (Company deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteSupplierCompany(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a Person in the system
	 *
	 * @param principal
	 * @param supplierId
	 * @param id
	 * @return
	 *         200 (Person deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteSupplierPerson(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Deletes a PhoneNumber in the system
	 *
	 * @param principal
	 * @param supplierId
	 * @param id
	 * @return
	 *         200 (PhoneNumber deleted)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Void> deleteSupplierPhoneNumber(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Retrieves a customer stored in the system
	 *
	 * @param principal
	 * @param id
	 * @return
	 *         200 (Customer found)
	 */
	ResponseEntity<CustomerDetail> getCustomer(Principal principal, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Retrieves all of the customers stored in the system
	 *
	 * @param principal
	 * @return
	 *         200 (Customers records found)
	 */
	ResponseEntity<List<CustomerDetail>> getCustomers(Principal principal) throws Exception;

	/**
	 * Retrieves a supplier stored in the system
	 *
	 * @param principal
	 * @param id
	 * @return
	 *         200 (Supplier found)
	 */
	ResponseEntity<SupplierDetail> getSupplier(Principal principal, @PathVariable("id") Integer id) throws Exception;

	/**
	 * Retrieves all of the suppliers stored in the system
	 *
	 * @param principal
	 * @return
	 *         200 (Supplier records found)
	 */
	ResponseEntity<List<SupplierDetail>> getSuppliers(Principal principal) throws Exception;

	/**
	 * Updates a Customer contact in the system
	 *
	 * @param principal
	 * @param id
	 * @param customer
	 * @return
	 *         200 (Customer contact updated)
	 *         400 (invalid input, object invalid)
	 *         409 (Customer contact already exists)
	 */
	ResponseEntity<Customer> updateCustomer(Principal principal, @PathVariable("id") Integer id, @Valid @RequestBody Customer customer) throws Exception;

	/**
	 * Updates a company in the system
	 *
	 * @param principal
	 * @param customerId
	 * @param id
	 * @param company
	 * @return
	 *         200 (Company updated)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Company> updateCustomerCompany(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id, @Valid @RequestBody Company company) throws Exception;

	/**
	 * Updates a Person in the system
	 *
	 * @param principal
	 * @param customerId
	 * @param id
	 * @param person
	 * @return
	 *         200 (Person updated)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Person> updateCustomerPerson(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id, @Valid @RequestBody Person person) throws Exception;

	/**
	 * Updates a PhoneNumber in the system
	 *
	 * @param principal
	 * @param customerId
	 * @param id
	 * @param phoneNumber
	 * @return
	 *         200 (PhoneNumber updated)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<PhoneNumber> updateCustomerPhoneNumber(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id, @Valid @RequestBody PhoneNumber phoneNumber) throws Exception;

	/**
	 * Updates a Supplier contact in the system
	 *
	 * @param principal
	 * @param id
	 * @param supplier
	 * @return
	 *         200 (Supplier contact updated)
	 *         400 (invalid input, object invalid)
	 *         409 (Supplier contact already exists)
	 */
	ResponseEntity<Supplier> updateSupplier(Principal principal, @PathVariable("id") Integer id, @Valid @RequestBody Supplier supplier) throws Exception;

	/**
	 * Updates a company in the system
	 *
	 * @param principal
	 * @param supplierId
	 * @param id
	 * @param company
	 * @return
	 *         200 (Company updated)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Company> updateSupplierCompany(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id, @Valid @RequestBody Company company) throws Exception;

	/**
	 * Updates a Person in the system
	 *
	 * @param principal
	 * @param supplierId
	 * @param id
	 * @param person
	 * @return
	 *         200 (Person updated)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<Person> updateSupplierPerson(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id, @Valid @RequestBody Person person) throws Exception;

	/**
	 * Updates a PhoneNumber in the system
	 *
	 * @param principal
	 * @param supplierId
	 * @param id
	 * @param phoneNumber
	 * @return
	 *         200 (PhoneNumber updated)
	 *         400 (invalid input, object invalid)
	 */
	ResponseEntity<PhoneNumber> updateSupplierPhoneNumber(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id, @Valid @RequestBody PhoneNumber phoneNumber) throws Exception;
}