package com.writing.management.tool.WPMTools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WPMDateTools {

	//TODO Add the Methods from the SubmissionsLookup Class here
	
	/**
	 * Takes the value of a date and parses it the YearMonthDay 
	 * format used in the created of new submissions
	 * 
	 * @param localDate the date to be parsed to a string
	 * @return as converted string with the date passed in the form yyyyMMdd (Year, Month, Day)
	 */
	public static String parseDate(LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return localDate.format(formatter).toString();
	}
	
}
