package com.goliathdev.contacts.entity.rule;

import org.springframework.stereotype.Component;

/**
 * Uses the decorator pattern to provide rules/validation per object.
 * */
@Component
public class ValidatorImpl implements Validator {

	@Override
	public boolean isValid(Validatable validatable) {
		return validatable.isValid();
	}

}