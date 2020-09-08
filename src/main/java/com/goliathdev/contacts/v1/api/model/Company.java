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
 * A company entity
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

	private Integer id = null;

	private String name = null;

	private String registrationNumber = null;

	// Default constructor required when using overloaded constructor.
	public Company () {}

	// Constructor
	public Company(Integer id, String name, String registrationNumber) {
		setId(id);
		setName(name);
		setRegistrationNumber(registrationNumber);
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Company company = (Company) obj;
		return Objects.equals(this.id, company.id) && Objects.equals(this.name, company.name) && Objects.equals(this.registrationNumber, company.registrationNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, registrationNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Company {\n");
		sb.append("  id: ").append(Objects.toString(id, "null")).append("\n");
		sb.append("  name: ").append(Objects.toString(name, "null")).append("\n");
		sb.append("  registrationNumber: ").append(Objects.toString(registrationNumber, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
