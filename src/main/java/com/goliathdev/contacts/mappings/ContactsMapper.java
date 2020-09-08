package com.goliathdev.contacts.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.goliathdev.contacts.entity.Company;
import com.goliathdev.contacts.entity.Customer;
import com.goliathdev.contacts.entity.Person;
import com.goliathdev.contacts.entity.PhoneNumber;
import com.goliathdev.contacts.entity.Supplier;

/**
 * MapStruct mapper to convert REST API DTOs to DB Entities.
 * */
@Mapper(uses = { MetaMapper.class })
public interface ContactsMapper {

	ContactsMapper INSTANCE = Mappers.getMapper(ContactsMapper.class);

//	@Mapping(target = "id", source = "company.id")
//	@Mapping(target = "name", source = "company.name")
//	@Mapping(target = "registrationNumber", source = "company.registrationNumber")
//	@Mapping(target = "customer", source = "company.customer")
//	@Mapping(target = "supplier", source = "company.supplier")
//	@Mapping(target = "phoneNumbers", source = "company.phoneNumbers")
//	Company toCompany(ContactItem contactItem);
//
//	@Mapping(target = "id", source = "person.id")
//	@Mapping(target = "firstName", source = "person.firstName")
//	@Mapping(target = "lastName", source = "person.lastName")
//	@Mapping(target = "customer", source = "person.customer")
//	@Mapping(target = "supplier", source = "person.supplier")
//	@Mapping(target = "phoneNumbers", source = "person.phoneNumbers")
//	Person toPerson(ContactItem contactItem);
	
//	@Mapping(target = "customerNumber", source = "customer.customerNumber")
//	@Mapping(target = "lastOrderDate", source = "customer.lastOrderDate")
//	@Mapping(target = "company", source = "customer.company")
//	@Mapping(target = "person", source = "customer.person")
	Customer toCustomer(com.goliathdev.contacts.v1.api.model.Customer customer);
	com.goliathdev.contacts.v1.api.model.Customer toCustomer(Customer customer);
	Customer toCustomer(com.goliathdev.contacts.v1.api.model.CustomerDetail customer);
	com.goliathdev.contacts.v1.api.model.CustomerDetail toCustomerDetail(Customer customer);
	
	Supplier toSupplier(com.goliathdev.contacts.v1.api.model.Supplier supplier);
	Supplier toSupplier(com.goliathdev.contacts.v1.api.model.SupplierDetail supplier);
	com.goliathdev.contacts.v1.api.model.Supplier toSupplier(Supplier supplier);
	com.goliathdev.contacts.v1.api.model.SupplierDetail toSupplierDetail(Supplier supplier);
	
	Company toCompany(com.goliathdev.contacts.v1.api.model.Company company);
	com.goliathdev.contacts.v1.api.model.Company toCompany(Company company);
	
	Person toPerson(com.goliathdev.contacts.v1.api.model.Person person);
	com.goliathdev.contacts.v1.api.model.Person toPerson(Person person);
	
	PhoneNumber toPhoneNumber(com.goliathdev.contacts.v1.api.model.PhoneNumber phoneNumber);
	com.goliathdev.contacts.v1.api.model.PhoneNumber toPhoneNumber(PhoneNumber phoneNumber);
	
//	@Mapping(target = "id", source = "supplier.id")
//	@Mapping(target = "taxNumber", source = "supplier.taxNumber")
//	@Mapping(target = "orderLeadTimeInDays", source = "supplier.orderLeadTimeInDays")
//	@Mapping(target = "company", source = "supplier.company")
//	@Mapping(target = "person", source = "supplier.person")
//	Supplier toSupplier(ContactItem contactItem);
	
	

//	Customer toCustomer(com.goliathdev.contacts.api.model.Customer customer);
//	com.goliathdev.contacts.api.model.Customer toCustomer(Customer customer);

//	Supplier toSupplier(com.goliathdev.contacts.api.model.Supplier supplier);
//	com.goliathdev.contacts.api.model.Supplier toSupplier(Supplier supplier);

}
