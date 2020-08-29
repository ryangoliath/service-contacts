package com.goliathdev.contacts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String taxNumber;

	private int orderLeadTimeInDays;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public int getOrderLeadTimeInDays() {
		return orderLeadTimeInDays;
	}

	public void setOrderLeadTimeInDays(int orderLeadTimeInDays) {
		this.orderLeadTimeInDays = orderLeadTimeInDays;
	}

}
