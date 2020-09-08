package com.goliathdev.contacts.v1.worker;

import org.springframework.stereotype.Service;

/**
 * Worker Service which coordinates messages between the API layer and ContactsManager.
 */
@Service
@SuppressWarnings({ "rawtypes" })
public class V1WorkerOld  {

//	private static final Logger logger = LoggerFactory.getLogger(V1WorkerOld.class);
//	
//	private ContactsMapper mapper = ContactsMapper.INSTANCE;
//
//	@Autowired
//	private Validator validator;
//
//	@Autowired
//	private ContactsManager contactsManager;
//
//	@Override
//	public ResponseEntity<com.goliathdev.contacts.v1.api.model.Customer> addCustomer(Principal principal,
//			com.goliathdev.contacts.v1.api.model.@Valid Customer customer) throws Exception {
//		Customer response = null;
//
//		com.goliathdev.contacts.entity.Customer customerEntity = mapper.toCustomer(customer);
//
//		if (!validator.isValid(customerEntity)) {
//			logger.warn(StatusCode.ERROR_CUSTOMER_400.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_400),
//					StatusCode.ERROR_CUSTOMER_400.getHttpStatus());
//		}
//
//		customerEntity = contactsManager.save(customerEntity);
//
//		if (customerEntity == null) {
//			return new ResponseEntity<>("A technical error occured while attempting to save the customer contact.",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response = mapper.toCustomer(customerEntity);
//
//		return new ResponseEntity<com.goliathdev.contacts.v1.api.model.Customer>(response, HttpStatus.CREATED);
//	}
//
//	@Override
//	public ResponseEntity<com.goliathdev.contacts.v1.api.model.Supplier> addSupplier(Principal principal,
//			com.goliathdev.contacts.v1.api.model.@Valid Supplier customer) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Void> deleteCompany(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Void> deleteCustomer(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Void> deletePerson(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Void> deletePhoneNumber(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Void> deleteSupplier(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Company> getCompany(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<com.goliathdev.contacts.v1.api.model.Customer> getCustomer(Principal principal, Integer id)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<List<com.goliathdev.contacts.v1.api.model.Customer>> getCustomers(Principal principal)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Person> getPerson(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<PhoneNumber> getPhoneNumber(Principal principal, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<com.goliathdev.contacts.v1.api.model.Supplier> getSupplier(Principal principal, Integer id)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<List<com.goliathdev.contacts.v1.api.model.Supplier>> getSuppliers(Principal principal)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Company> updateCompany(Principal principal, Integer id, @Valid Company company)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<com.goliathdev.contacts.v1.api.model.Customer> updateCustomer(Principal principal, Integer id,
//			com.goliathdev.contacts.v1.api.model.@Valid Customer customer) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Person> updatePerson(Principal principal, Integer id, @Valid Person person) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<PhoneNumber> updatePhoneNumber(Principal principal, Integer id,
//			@Valid PhoneNumber phoneNumber) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<com.goliathdev.contacts.v1.api.model.Supplier> updateSupplier(Principal principal, Integer id,
//			com.goliathdev.contacts.v1.api.model.@Valid Supplier supplier) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}



//
//	@Override
//	public ResponseEntity saveCustomer(Customer customer) {
//		logger.info("saveCustomer() : {}", customer.toString());
//
//		Customer response = null;
//
//		com.goliathdev.contacts.entity.Customer customerEntity = mapper.toCustomer(customer);
//
//		if (!validator.isValid(customerEntity)) {
//			logger.warn(StatusCode.ERROR_CUSTOMER_400.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_400),
//					StatusCode.ERROR_CUSTOMER_400.getHttpStatus());
//		}
//
//		customerEntity = contactsManager.save(customerEntity);
//
//		if (customerEntity == null) {
//			return new ResponseEntity<>("A technical error occured while attempting to save the customer contact.",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response = mapper.toCustomer(customerEntity);
//
//		return new ResponseEntity<Customer>(response, HttpStatus.CREATED);
//	}
//
//	@Override
//	public ResponseEntity saveSupplier(Supplier supplier) {
//		logger.info("saveSupplier() : {}", supplier.toString());
//
//		Supplier response = null;
//
//		com.goliathdev.contacts.entity.Supplier supplierEntity = mapper.toSupplier(supplier);
//
//		if (!validator.isValid(supplierEntity)) {
//			logger.warn(StatusCode.ERROR_SUPPLIER_400.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_SUPPLIER_400),
//					StatusCode.ERROR_SUPPLIER_400.getHttpStatus());
//		}
//
//		supplierEntity = contactsManager.save(supplierEntity);
//
//		if (supplierEntity == null) {
//			return new ResponseEntity<>("A technical error occured while attempting to save the supplier contact.",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response = mapper.toSupplier(supplierEntity);
//
//		return new ResponseEntity<Supplier>(response, HttpStatus.CREATED);
//	}
//
//	@Override
//	public ResponseEntity getCustomer(Long id) {
//		logger.info("getCustomer()");
//
//		Customer response = null;
//
//		com.goliathdev.contacts.entity.Customer customer = contactsManager.findCustomerBy(id);
//
//		if (customer == null) {
//			logger.warn(StatusCode.ERROR_CUSTOMER_404.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_404),
//					StatusCode.ERROR_CUSTOMER_404.getHttpStatus());
//		}
//
//		// Map all customers to rest api customer models
//		response = mapper.toCustomer(customer);
//
//		return new ResponseEntity<Customer>(response, HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity getSupplier(Long id) {
//		logger.info("getSupplier()");
//
//		Supplier response = null;
//
//		com.goliathdev.contacts.entity.Supplier supplier = contactsManager.findSupplierBy(id);
//
//		if (supplier == null) {
//			logger.warn(StatusCode.ERROR_SUPPLIER_404.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_SUPPLIER_404),
//					StatusCode.ERROR_SUPPLIER_404.getHttpStatus());
//		}
//
//		// Map all customers to rest api customer models
//		response = mapper.toSupplier(supplier);
//
//		return new ResponseEntity<Supplier>(response, HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity updateCustomer(Long id, Customer customer) {
//		logger.info("updateCustomer() : {}", customer.toString());
//
//		Customer response = null;
//
//		com.goliathdev.contacts.entity.Customer customerEntity = contactsManager.findCustomerBy(id);
//
//		if (customerEntity == null) {
//			logger.warn(StatusCode.ERROR_CUSTOMER_404.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_404),
//					StatusCode.ERROR_CUSTOMER_404.getHttpStatus());
//		}
//		
//		customerEntity = mapper.toCustomer(customer);
//		customerEntity.setCustomerNumber(id);
//		
//		if (!validator.isValid(customerEntity)) {
//			logger.warn(StatusCode.ERROR_CUSTOMER_400.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_400),
//					StatusCode.ERROR_CUSTOMER_400.getHttpStatus());
//		}
//
//		contactsManager.save(customerEntity);
//
//		response = mapper.toCustomer(customerEntity);
//
//		return new ResponseEntity<Customer>(response, HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity updateSupplier(Long id, Supplier supplier) {
//		logger.info("updateSupplier() : {}", supplier.toString());
//
//		Supplier response = null;
//
//		com.goliathdev.contacts.entity.Supplier supplierEntity = contactsManager.findSupplierBy(id);
//		
//		if (supplierEntity == null) {
//			logger.warn(StatusCode.ERROR_SUPPLIER_404.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_SUPPLIER_404),
//					StatusCode.ERROR_SUPPLIER_404.getHttpStatus());
//		}
//		
//		supplierEntity = mapper.toSupplier(supplier);
//		supplierEntity.setId(id);
//
//		if (!validator.isValid(supplierEntity)) {
//			logger.warn(StatusCode.ERROR_SUPPLIER_400.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_SUPPLIER_400),
//					StatusCode.ERROR_SUPPLIER_400.getHttpStatus());
//		}
//
//		contactsManager.save(supplierEntity);
//
//		response = mapper.toSupplier(supplierEntity);
//
//		return new ResponseEntity<Supplier>(response, HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity getCustomers() {
//		logger.info("getCustomers()");
//
//		List<Customer> response = null;
//
//		List<com.goliathdev.contacts.entity.Customer> customerEntities = contactsManager.findAllCustomers();
//
//		if (CollectionUtils.isEmpty(customerEntities)) {
//			logger.warn(StatusCode.ERROR_CUSTOMER_404.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_404),
//					StatusCode.ERROR_CUSTOMER_404.getHttpStatus());
//		}
//
//		// Map all customers to rest api customer models
//		response = customerEntities.stream().map(customer -> mapper.toCustomer(customer)).collect(Collectors.toList());
//
//		return new ResponseEntity<List<Customer>>(response, HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity getSuppliers() {
//		logger.info("getSuppliers()");
//
//		List<Supplier> response = null;
//
//		List<com.goliathdev.contacts.entity.Supplier> supplierEntities = contactsManager.findAllSuppliers();
//
//		if (CollectionUtils.isEmpty(supplierEntities)) {
//			logger.warn(StatusCode.ERROR_SUPPLIER_404.getDescription());
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_SUPPLIER_404),
//					StatusCode.ERROR_SUPPLIER_404.getHttpStatus());
//		}
//
//		// Map all suppliers to rest api supplier models
//		response = supplierEntities.stream().map(supplier -> mapper.toSupplier(supplier)).collect(Collectors.toList());
//
//		return new ResponseEntity<List<Supplier>>(response, HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity deleteCustomer(Long id) {
//		logger.info("deleteCustomer()");
//		
//		try {
//			contactsManager.deleteCustomer(id);
//		} catch(EmptyResultDataAccessException e) {
//			logger.warn("Could not delete customer [{}]", id, e);
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_CUSTOMER_404),
//					StatusCode.ERROR_CUSTOMER_404.getHttpStatus());
//		}
//		
//		return new ResponseEntity<ContactError>(new ContactError(StatusCode.SUCCESS_CUSTOMER_200_DELETE),
//				StatusCode.SUCCESS_CUSTOMER_200_DELETE.getHttpStatus());
//	}
//
//	@Override
//	public ResponseEntity deleteSupplier(Long id) {
//		logger.info("deleteSupplier()");
//		
//		try {
//			contactsManager.deleteSupplier(id);
//		} catch(EmptyResultDataAccessException e) {
//			logger.warn("Could not delete supplier [{}]", id, e);
//			return new ResponseEntity<ContactError>(new ContactError(StatusCode.ERROR_SUPPLIER_404),
//					StatusCode.ERROR_SUPPLIER_404.getHttpStatus());
//		}
//		
//		return new ResponseEntity<ContactError>(new ContactError(StatusCode.SUCCESS_SUPPLIER_200_DELETE),
//				StatusCode.SUCCESS_SUPPLIER_200_DELETE.getHttpStatus());
//	}

}
