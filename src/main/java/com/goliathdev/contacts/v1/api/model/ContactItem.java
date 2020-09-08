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

@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T11:37:09.818+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactItem {

	private Customer customer = null;

	private Supplier supplier = null;

	// Default constructor required when using overloaded constructor.
	public ContactItem () {}

	// Constructor
	public ContactItem(Customer customer, Supplier supplier) {
		setCustomer(customer);
		setSupplier(supplier);
	}
	/**
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		ContactItem contactItem = (ContactItem) obj;
		return Objects.equals(this.customer, contactItem.customer) && Objects.equals(this.supplier, contactItem.supplier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, supplier);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ContactItem {\n");
		sb.append("  customer: ").append(Objects.toString(customer, "null")).append("\n");
		sb.append("  supplier: ").append(Objects.toString(supplier, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
