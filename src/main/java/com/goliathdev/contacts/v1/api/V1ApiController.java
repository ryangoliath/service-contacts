package com.goliathdev.contacts.v1.api;

import java.security.Principal;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goliathdev.contacts.v1.api.model.Company;
import com.goliathdev.contacts.v1.api.model.Customer;
import com.goliathdev.contacts.v1.api.model.CustomerDetail;
import com.goliathdev.contacts.v1.api.model.Person;
import com.goliathdev.contacts.v1.api.model.PhoneNumber;
import com.goliathdev.contacts.v1.api.model.Supplier;
import com.goliathdev.contacts.v1.api.model.SupplierDetail;
import com.goliathdev.contacts.v1.worker.V1Worker;

@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
@RequestMapping("/rest")
@RestController
@Validated
public class V1ApiController implements V1Api {

	private final Logger logger = LoggerFactory.getLogger(V1ApiController.class);
	
	@Autowired
	V1Worker v1Worker;
	
	@Override
	@RequestMapping(path = "/v1/customer", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<CustomerDetail> addCustomer(Principal principal, @Valid @RequestBody CustomerDetail customer) throws Exception {
		logger.trace("addCustomer()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.addCustomer(principal, customer);
		//return new ResponseEntity<CustomerDetail>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier", method = RequestMethod.POST, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierDetail> addSupplier(Principal principal, @Valid @RequestBody SupplierDetail customer) throws Exception {
		logger.trace("addSupplier()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.addSupplier(principal, customer);
		//return new ResponseEntity<SupplierDetail>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteCustomer(Principal principal, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteCustomer()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteCustomer(principal, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{customerId}/company/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteCustomerCompany(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteCustomerCompany()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteCustomerCompany(principal, customerId, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{customerId}/person/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteCustomerPerson(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteCustomerPerson()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteCustomerPerson(principal, customerId, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{customerId}/phoneNumber/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteCustomerPhoneNumber(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteCustomerPhoneNumber()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteCustomerPhoneNumber(principal, customerId, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteSupplier(Principal principal, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteSupplier()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteSupplier(principal, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{supplierId}/company/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteSupplierCompany(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteSupplierCompany()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteSupplierCompany(principal, supplierId, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{supplierId}/person/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteSupplierPerson(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteSupplierPerson()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteSupplierPerson(principal, supplierId, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{supplierId}/phoneNumber/{id}", method = RequestMethod.DELETE, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Void> deleteSupplierPhoneNumber(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id) throws Exception {
		logger.trace("deleteSupplierPhoneNumber()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.deleteSupplierPhoneNumber(principal, supplierId, id);
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<CustomerDetail> getCustomer(Principal principal, @PathVariable("id") Integer id) throws Exception {
		logger.trace("getCustomer()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.getCustomer(principal, id);
		//return new ResponseEntity<CustomerDetail>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customers", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<CustomerDetail>> getCustomers(Principal principal) throws Exception {
		logger.trace("getCustomers()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.getCustomers(principal);
		//return new ResponseEntity<List<CustomerDetail>>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<SupplierDetail> getSupplier(Principal principal, @PathVariable("id") Integer id) throws Exception {
		logger.trace("getSupplier()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.getSupplier(principal, id);
		//return new ResponseEntity<SupplierDetail>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/suppliers", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<SupplierDetail>> getSuppliers(Principal principal) throws Exception {
		logger.trace("getSuppliers()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.getSuppliers(principal);
		//return new ResponseEntity<List<SupplierDetail>>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Customer> updateCustomer(Principal principal, @PathVariable("id") Integer id, @Valid @RequestBody Customer customer) throws Exception {
		logger.trace("updateCustomer()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateCustomer(principal, id, customer);
		//return new ResponseEntity<Customer>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{customerId}/company/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Company> updateCustomerCompany(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id, @Valid @RequestBody Company company) throws Exception {
		logger.trace("updateCustomerCompany()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateCustomerCompany(principal, customerId, id, company);
		//return new ResponseEntity<Company>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{customerId}/person/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Person> updateCustomerPerson(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id, @Valid @RequestBody Person person) throws Exception {
		logger.trace("updateCustomerPerson()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateCustomerPerson(principal, customerId, id, person);
		//return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/customer/{customerId}/phoneNumber/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<PhoneNumber> updateCustomerPhoneNumber(Principal principal, @PathVariable("customerId") Integer customerId, @PathVariable("id") Integer id, @Valid @RequestBody PhoneNumber phoneNumber) throws Exception {
		logger.trace("updateCustomerPhoneNumber()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateCustomerPhoneNumber(principal, customerId, id, phoneNumber);
		//return new ResponseEntity<PhoneNumber>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Supplier> updateSupplier(Principal principal, @PathVariable("id") Integer id, @Valid @RequestBody Supplier supplier) throws Exception {
		logger.trace("updateSupplier()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateSupplier(principal, id, supplier);
		//return new ResponseEntity<Supplier>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{supplierId}/company/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Company> updateSupplierCompany(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id, @Valid @RequestBody Company company) throws Exception {
		logger.trace("updateSupplierCompany()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateSupplierCompany(principal, supplierId, id, company);
		//return new ResponseEntity<Company>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{supplierId}/person/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Person> updateSupplierPerson(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id, @Valid @RequestBody Person person) throws Exception {
		logger.trace("updateSupplierPerson()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateSupplierPerson(principal, supplierId, id, person);
		//return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(path = "/v1/supplier/{supplierId}/phoneNumber/{id}", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<PhoneNumber> updateSupplierPhoneNumber(Principal principal, @PathVariable("supplierId") Integer supplierId, @PathVariable("id") Integer id, @Valid @RequestBody PhoneNumber phoneNumber) throws Exception {
		logger.trace("updateSupplierPhoneNumber()");
		// TODO: Add your implementation code in a V1ApiWorker class. If this class is regenerated you won't lose your code.
		return v1Worker.updateSupplierPhoneNumber(principal, supplierId, id, phoneNumber);
		//return new ResponseEntity<PhoneNumber>(HttpStatus.OK);
	}
}
