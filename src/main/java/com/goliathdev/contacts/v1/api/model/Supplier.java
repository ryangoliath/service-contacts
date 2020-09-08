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
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Supplier {

	private Integer id = null;

	private String taxNumber = null;

	private Integer orderLeadTimeInDays = null;

	// Default constructor required when using overloaded constructor.
	public Supplier () {}

	// Constructor
	public Supplier(Integer id, String taxNumber, Integer orderLeadTimeInDays) {
		setId(id);
		setTaxNumber(taxNumber);
		setOrderLeadTimeInDays(orderLeadTimeInDays);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Supplier supplier = (Supplier) obj;
		return Objects.equals(this.id, supplier.id) && Objects.equals(this.taxNumber, supplier.taxNumber) && Objects.equals(this.orderLeadTimeInDays, supplier.orderLeadTimeInDays);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, taxNumber, orderLeadTimeInDays);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Supplier {\n");
		sb.append("  id: ").append(Objects.toString(id, "null")).append("\n");
		sb.append("  taxNumber: ").append(Objects.toString(taxNumber, "null")).append("\n");
		sb.append("  orderLeadTimeInDays: ").append(Objects.toString(orderLeadTimeInDays, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
