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
 * A Customer Detail contact
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T19:27:39.380+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetail {

	private Integer customerNumber = null;

	private String lastOrderDate = null;

	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

	private Company company = null;

	private Person person = null;

	private Error error = null;

	// Default constructor required when using overloaded constructor.
	public CustomerDetail () {}

	// Constructor
	public CustomerDetail(Integer customerNumber, String lastOrderDate, List<PhoneNumber> phoneNumbers, Company company, Person person, Error error) {
		setCustomerNumber(customerNumber);
		setLastOrderDate(lastOrderDate);
		setPhoneNumbers(phoneNumbers);
		setCompany(company);
		setPerson(person);
		setError(error);
	}
	/**
	 * @return customerNumber
	 */
	public Integer getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return lastOrderDate
	 */
	public String getLastOrderDate() {
		return lastOrderDate;
	}
	public void setLastOrderDate(String lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
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

		CustomerDetail customerDetail = (CustomerDetail) obj;
		return Objects.equals(this.customerNumber, customerDetail.customerNumber) && Objects.equals(this.lastOrderDate, customerDetail.lastOrderDate) && Objects.equals(this.phoneNumbers, customerDetail.phoneNumbers) && Objects.equals(this.company, customerDetail.company) && Objects.equals(this.person, customerDetail.person) && Objects.equals(this.error, customerDetail.error);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerNumber, lastOrderDate, phoneNumbers, company, person, error);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CustomerDetail {\n");
		sb.append("  customerNumber: ").append(Objects.toString(customerNumber, "null")).append("\n");
		sb.append("  lastOrderDate: ").append(Objects.toString(lastOrderDate, "null")).append("\n");
		sb.append("  phoneNumbers: ").append(Objects.toString(phoneNumbers, "null")).append("\n");
		sb.append("  company: ").append(Objects.toString(company, "null")).append("\n");
		sb.append("  person: ").append(Objects.toString(person, "null")).append("\n");
		sb.append("  error: ").append(Objects.toString(error, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
