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
 * An error thrown by the contacts system
 */
@Generated(value = "swagger-codegen-cli-2.2.1.jar", date = "2020-09-08T19:27:39.380+02:00 ", comments="swagger2server.bat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

	private String description = null;

	private Integer statusCode = null;

	// Default constructor required when using overloaded constructor.
	public Error () {}

	// Constructor
	public Error(String description, Integer statusCode) {
		setDescription(description);
		setStatusCode(statusCode);
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Error error = (Error) obj;
		return Objects.equals(this.description, error.description) && Objects.equals(this.statusCode, error.statusCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, statusCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Error {\n");
		sb.append("  description: ").append(Objects.toString(description, "null")).append("\n");
		sb.append("  statusCode: ").append(Objects.toString(statusCode, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
