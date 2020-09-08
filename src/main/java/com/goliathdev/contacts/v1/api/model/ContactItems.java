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
public class ContactItems {

	private ContactItem items = null;

	// Default constructor required when using overloaded constructor.
	public ContactItems () {}

	// Constructor
	public ContactItems(ContactItem items) {
		setItems(items);
	}
	/**
	 * @return items
	 */
	public ContactItem getItems() {
		return items;
	}
	public void setItems(ContactItem items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		ContactItems contactItems = (ContactItems) obj;
		return Objects.equals(this.items, contactItems.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(items);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ContactItems {\n");
		sb.append("  items: ").append(Objects.toString(items, "null")).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
