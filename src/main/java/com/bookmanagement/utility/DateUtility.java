package com.bookmanagement.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	
	
	public static Date getCurrentDate() {
		return new Date();
	}
	
	public static String setDobFormat(Date date) throws ParseException  {
		SimpleDateFormat dobFormat = new SimpleDateFormat(ApplicationConstants.DOB_FORMAT);
		String dt = dobFormat.format(date);
//		return dobFormat.parse(dt);
		return dt;
	}
	
	public static Date stringToDate(String date,String format) throws ParseException  {
		SimpleDateFormat dobFormat = new SimpleDateFormat(format);
		return dobFormat.parse(date);
	}

}
