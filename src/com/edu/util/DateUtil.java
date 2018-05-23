package com.edu.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/*public static Date addHours(int hours) {
		Date date = new Date();
		LocalDate ld = convertToLocalDate(date);
		
	}*/
	
	public static Calendar convertToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static Date convertToDate(Calendar calendar) {
		return calendar.getTime();
	}
	
	public static Date formatDate(Date date) {
		Calendar cal = convertToCalendar(date);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return convertToDate(cal);
	}
	
	public static Date addHours(Date date, int hours) {
		Calendar cal = convertToCalendar(formatDate(date));
		int h = cal.get(Calendar.HOUR);
		cal.set(Calendar.HOUR, h + hours);
		return convertToDate(cal);
	}
	
	public static Date addDays(Date date, int days) {
		Calendar cal = convertToCalendar(formatDate(date));
		int d = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, days + d);
		return convertToDate(cal);
	}
	public static LocalDate convertToLocalDate(Date date) {
		Instant instant = date.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate ld = zdt.toLocalDate();
		return ld;
	}
}
