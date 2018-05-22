package com.edu.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {
	
	/*public static Date addHours(int hours) {
		Date date = new Date();
		LocalDate ld = convertToLocalDate(date);
		
	}*/
	
	public static LocalDate convertToLocalDate(Date date) {
		Instant instant = date.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate ld = zdt.toLocalDate();
		return ld;
	}
}
