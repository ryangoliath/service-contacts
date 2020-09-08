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
 * A Person entity. May be a Customer or Supplier at the same time.
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	private Integer id = null;

	private String firstName = null;

	private String lastName = null;

	// Default constructor required when using overloaded constructor.
	public Person () {}

	// Constructor
	public Person(Integer id, String firstName, String lastName) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
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
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Person person = (Person) obj;
		return Objects.equals(this.id, person.id) && Objects.equals(this.firstName, person.firstName) && Objects.equals(this.lastName, person.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");
		sb.append("  id: ").append(Objects.toString(id, "null")).append("\n");
		sb.append("  firstName: ").append(Objects.toString(firstName, "null")).append("\n");
		sb.append("  lastName: ").append(Objects.toString(lastName, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
