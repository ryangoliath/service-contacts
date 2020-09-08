package com.goliathdev.contacts.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.util.StringUtils;

import com.goliathdev.contacts.entity.rule.Validatable;

@Entity
public class Supplier implements Validatable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String taxNumber;

	private int orderLeadTimeInDays;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Company company;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public boolean isValid() {
		
		if(getPerson() == null && getCompany() == null) {
			return false;
		}
		
		if(getPerson() != null && getCompany() != null) {
			return false;
		}
		
		if(getCompany() != null && !StringUtils.isEmpty(getCompany().getName()) && !StringUtils.isEmpty(getCompany().getRegistrationNumber())) {
			return true;
		} else if(getPerson() != null && !StringUtils.isEmpty(getPerson().getFirstName()) && !StringUtils.isEmpty(getPerson().getLastName())) {
			return true;
		}
		
		return false;
	}

}
