package com.mgr.learn.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String yyyy_MM_ddStr = "yyyy-MM-dd";

	public static final String yyyyMMddhhmmssStr = "yyyy-MM-dd HH:mm:ss";

	public static final String yyyyMMddHHmmssStr_WithoutMinus = "yyyyMMddHHmmss";

	public static final String yyyyMMddStr_WithoutMinus = "yyyyMMdd";

	public static final String yyyyMMdd_CN = "yyyy年MM月dd日";

	public DateUtil() {

	}

	/**
	 * 获取当前时间字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return String
	 */
	public static String dateToStr(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串转date
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return Date
	 */
	public static Date strToDate(String dateStr, String pattern) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
		}
		return date;
	}

	/**
	 * 获取当前几小时之后的时间
	 * 
	 * @param hours
	 * @return Date
	 */
	public static Date getAfterHourDate(int hours) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, hours);
		return cal.getTime();
	}

	/**
	 * 获取当天整点时间
	 * 
	 * @param hours
	 * @return
	 */
	public static Date getDayHourDate(int hours) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
}
