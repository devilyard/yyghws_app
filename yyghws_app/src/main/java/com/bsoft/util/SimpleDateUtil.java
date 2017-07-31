package com.bsoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateUtil {
	
	public static SimpleDateFormat getFormat(String format){
		return new SimpleDateFormat(format);
	}
	
	// Date --> String
	public static String format(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String formatDateTime(Date date){
		return new SimpleDateFormat(DATETIME_FORMAT).format(date);
	}
	
	public static String formatDate(Date date){
		return new SimpleDateFormat(DATE_FORMAT).format(date);
	}
	
	public static String formatTime(Date date){
		return new SimpleDateFormat(TIME_FORMAT).format(date);
	}
	
	// String --> Date
	public static Date parse(String date,String format) throws ParseException{
		return new SimpleDateFormat(format).parse(date);
	}
	
	public static Date parseDateTime(String date) throws ParseException{
		return new SimpleDateFormat(DATETIME_FORMAT).parse(date);
	}
	
	public static Date parseDate(String date) throws ParseException{
		return new SimpleDateFormat(DATE_FORMAT).parse(date);
	}
	
	public static Date parseTime(String date) throws ParseException{
		return new SimpleDateFormat(TIME_FORMAT).parse(date);
	}
	
	private static final String FIX = "-";
	private static final String SPACE = " ";
	private static final String COLON = ":";
	public static final String YEAR_FORMAT = "yyyy";
	private static final String MONTH_FORMAT = "MM";
	private static final String DAY_FORMAT = "dd";
	public static final String YEAR_MONTH_FORMAT = YEAR_FORMAT+FIX+MONTH_FORMAT;
	public static final String DATE_FORMAT = YEAR_MONTH_FORMAT+FIX+DAY_FORMAT;
	private static final String HOUR_FORMAT = "HH";
	private static final String MINUTE_FORMAT = "mm";
	private static final String SECOND_FORMAT = "ss";
	public static final String TIME_FORMAT = HOUR_FORMAT+COLON+MINUTE_FORMAT+COLON+SECOND_FORMAT;
	public static final String DATETIME_FORMAT = DATE_FORMAT+SPACE+TIME_FORMAT;
	
}
