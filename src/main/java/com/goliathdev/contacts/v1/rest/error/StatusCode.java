package com.goliathdev.contacts.v1.rest.error;

import org.springframework.http.HttpStatus;

public enum StatusCode {
	
	ERROR_CUSTOMER_400(HttpStatus.BAD_REQUEST, "Validation failed. Fields are mandatory. A customer cannot be a Person and a Company at the same time."),
	ERROR_CUSTOMER_404(HttpStatus.NOT_FOUND, "Customer Not Found"),
	SUCCESS_CUSTOMER_200_DELETE(HttpStatus.OK, "Customer successfully deleted."),
	ERROR_SUPPLIER_400(HttpStatus.BAD_REQUEST, "Validation failed. Fields are mandatory. A supplier cannot be a Person and a Company at the same time."),
	ERROR_SUPPLIER_404(HttpStatus.NOT_FOUND, "Supplier Not Found"),
	SUCCESS_SUPPLIER_200_DELETE(HttpStatus.OK, "Supplier successfully deleted.");
	
	private HttpStatus httpStatus;
	private String description;
	
	private StatusCode(HttpStatus httpStatus, String description) {
		this.httpStatus = httpStatus;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
}
