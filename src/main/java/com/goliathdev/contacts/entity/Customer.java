package com.goliathdev.contacts.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Customer implements Validatable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerNumber;
	
	@Column(nullable = false)
	private Date lastOrderDate;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Company company;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Person person;

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
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

	/* 
	 * Validation:
	 * A customer can be a person or a company, but not both.
	 * */
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
