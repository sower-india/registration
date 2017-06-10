package com.sower.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sower.common.constants.CommonConstants;

public class DateUtil {
	
//	private String dateFormat
	
	
	public static Date getCurrentDate(final String strDateFormat) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		Date date = new Date();
		String currentDateString=dateFormat.format(date);
		date = dateFormat.parse(currentDateString);
		return date;
	}
	
	public static Date getCurrentDate(final long timeInMillis,final String strDateFormat) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		Date date = new Date(timeInMillis);
		String currentDateString=dateFormat.format(date);
		date = dateFormat.parse(currentDateString);
		return date;
	}
	
	
	public static Date getCurrentDate(final long timeInMillis) throws ParseException
	{
		return getCurrentDate(timeInMillis, CommonConstants.dateFormat);
	}
		
	
	public static Date getCurrentDate() throws ParseException
	{
		return getCurrentDate(CommonConstants.dateFormat);
	}

}
