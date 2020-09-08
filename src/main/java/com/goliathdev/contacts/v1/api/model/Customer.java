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
 * A Customer contact
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	private Integer customerNumber = null;

	private String lastOrderDate = null;

	// Default constructor required when using overloaded constructor.
	public Customer () {}

	// Constructor
	public Customer(Integer customerNumber, String lastOrderDate) {
		setCustomerNumber(customerNumber);
		setLastOrderDate(lastOrderDate);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Customer customer = (Customer) obj;
		return Objects.equals(this.customerNumber, customer.customerNumber) && Objects.equals(this.lastOrderDate, customer.lastOrderDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerNumber, lastOrderDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");
		sb.append("  customerNumber: ").append(Objects.toString(customerNumber, "null")).append("\n");
		sb.append("  lastOrderDate: ").append(Objects.toString(lastOrderDate, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
