package com.goliathdev.contacts.v1.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import javax.annotation.Generated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

/**
 * A Supplier contact
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T19:27:39.380+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierDetail {

	private Integer id = null;

	private String taxNumber = null;

	private Integer orderLeadTimeInDays = null;

	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

	private Company company = null;

	private Person person = null;

	private Error error = null;

	// Default constructor required when using overloaded constructor.
	public SupplierDetail () {}

	// Constructor
	public SupplierDetail(Integer id, String taxNumber, Integer orderLeadTimeInDays, List<PhoneNumber> phoneNumbers, Company company, Person person, Error error) {
		setId(id);
		setTaxNumber(taxNumber);
		setOrderLeadTimeInDays(orderLeadTimeInDays);
		setPhoneNumbers(phoneNumbers);
		setCompany(company);
		setPerson(person);
		setError(error);
	}
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return taxNumber
	 */
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	/**
	 * @return orderLeadTimeInDays
	 */
	public Integer getOrderLeadTimeInDays() {
		return orderLeadTimeInDays;
	}
	public void setOrderLeadTimeInDays(Integer orderLeadTimeInDays) {
		this.orderLeadTimeInDays = orderLeadTimeInDays;
	}

	/**
	 * @return phoneNumbers
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return company
	 */
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return person
	 */
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return error
	 */
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		SupplierDetail supplierDetail = (SupplierDetail) obj;
		return Objects.equals(this.id, supplierDetail.id) && Objects.equals(this.taxNumber, supplierDetail.taxNumber) && Objects.equals(this.orderLeadTimeInDays, supplierDetail.orderLeadTimeInDays) && Objects.equals(this.phoneNumbers, supplierDetail.phoneNumbers) && Objects.equals(this.company, supplierDetail.company) && Objects.equals(this.person, supplierDetail.person) && Objects.equals(this.error, supplierDetail.error);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, taxNumber, orderLeadTimeInDays, phoneNumbers, company, person, error);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SupplierDetail {\n");
		sb.append("  id: ").append(Objects.toString(id, "null")).append("\n");
		sb.append("  taxNumber: ").append(Objects.toString(taxNumber, "null")).append("\n");
		sb.append("  orderLeadTimeInDays: ").append(Objects.toString(orderLeadTimeInDays, "null")).append("\n");
		sb.append("  phoneNumbers: ").append(Objects.toString(phoneNumbers, "null")).append("\n");
		sb.append("  company: ").append(Objects.toString(company, "null")).append("\n");
		sb.append("  person: ").append(Objects.toString(person, "null")).append("\n");
		sb.append("  error: ").append(Objects.toString(error, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
