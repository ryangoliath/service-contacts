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
 * A phone number registered to a contact
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T18:54:28.237+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneNumber {

	private Integer id = null;

	private String areaCode = null;

	private String number = null;

	// Default constructor required when using overloaded constructor.
	public PhoneNumber () {}

	// Constructor
	public PhoneNumber(Integer id, String areaCode, String number) {
		setId(id);
		setAreaCode(areaCode);
		setNumber(number);
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
	 * @return areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return number
	 */
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		PhoneNumber phoneNumber = (PhoneNumber) obj;
		return Objects.equals(this.id, phoneNumber.id) && Objects.equals(this.areaCode, phoneNumber.areaCode) && Objects.equals(this.number, phoneNumber.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, areaCode, number);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PhoneNumber {\n");
		sb.append("  id: ").append(Objects.toString(id, "null")).append("\n");
		sb.append("  areaCode: ").append(Objects.toString(areaCode, "null")).append("\n");
		sb.append("  number: ").append(Objects.toString(number, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
