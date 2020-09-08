package com.goliathdev.contacts.mappings;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MetaMapper {
	
	private SimpleDateFormat defaultDateFormat;
	
	public Date asSqlDate(String date) {
		java.sql.Date sqlDate = null;
		
		try {
			java.util.Date parsed = getDefaultDateFormat().parse(date);
	    	sqlDate = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO: Do nothing. Return null.
		}
		
		return sqlDate;
	}
	
	public SimpleDateFormat getDefaultDateFormat() {
		if(defaultDateFormat == null) {
			defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
		return defaultDateFormat;
	}
	
}
