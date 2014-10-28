package com.server.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;


/**
 * 日期时间处理工具类
 * 
 * @author
 * @since
 * 
 */
public class DateTimeUtils {
	
	// 时区名称
	public static String zoneName = "GMT+8";
	
	// 默认格式化字符串
	public static String defaultFormatString = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 字符串转换为日期
	 * 
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date parseDate(String dateStr, String formatStr) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zoneName));
			return simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}

		return null;
	}

	/**
	 * 默认格式的转换字符串为日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, defaultFormatString);
	}

	/**
	 * 日期格式化为字符串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String formatDate(Date date, String formatStr) {
		if (date == null) {
			return null;
		}

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zoneName));
			return simpleDateFormat.format(date);
		} catch (Exception e) {
		}

		return null;
	}

	/**
	 * 默认格式的日期格式化为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return formatDate(date, defaultFormatString);
	}

	/**
	 * 默认格式的日期格式化为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(String date, String sourceFormat, String targetFormat) {
		return formatDate(parseDate(date, sourceFormat), targetFormat);
	}

	/**
	 * 返回年份
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 * @param add
	 * @return
	 */
	public static int getMonth(Date date, int add) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, add);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回周
	 * 
	 * @param date
	 *            日期
	 * @return 返回周
	 */
	public static int getWeek(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回日份
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回分钟
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回字符型日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		return formatDate(date, "yyyyMMdd");
	}

	/**
	 * 返回字符型时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getTime(Date date) {
		return formatDate(date, "HHmmss");
	}

	/**
	 * 返回字符型日期时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime(Date date) {
		return formatDate(date, defaultFormatString);
	}

	/**
	 * 获取一天前的时间
	 * 
	 * @param dateFormat
	 * @return
	 */
	public static String getYesterDay(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date date = cal.getTime();
		if (dateFormat != null)
			return formatDate(date, dateFormat);
		return formatDate(date, defaultFormatString);
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static String addDate(String date, String formatStr, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(parseDate(date, formatStr)) + ((long) day) * 24 * 3600 * 1000);
		return formatDate(c.getTime(), formatStr);
	}

	/**
	 * 月份相加
	 * 
	 * @param date
	 * @param add
	 * @return
	 */
	public static Date addMonth(Date date, int add) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, add);
		return c.getTime();
	}

	/**
	 * 获取一个月有多少天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		int maxDate = cal.getActualMaximum(Calendar.DATE);
		return maxDate;
	}
	
	/**
	 * 获取指定周的开始日期
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getWeekStartDate(int year, int week) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return formatDate(cal.getTime(), "yyyy/MM/dd");
	}

	/**
	 * 获取指定周的开始日期
	 * 
	 * @param year
	 * @param week
	 * @param formatStr
	 * @return
	 */
	public static String getWeekStartDate(int year, int week, String formatStr) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return formatDate(cal.getTime(), formatStr);
	}

	/**
	 * 获取指定周的结束日期
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getWeekEndDate(int year, int week) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return formatDate(cal.getTime(), "yyyy/MM/dd");
	}

	/**
	 * 获取指定周的结束日期
	 * 
	 * @param year
	 * @param week
	 * @param formatStr
	 * @return
	 */
	public static String getWeekEndDate(int year, int week, String formatStr) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return formatDate(cal.getTime(), formatStr);
	}

	/**
	 * 获取当前年的最大周数
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.setMinimalDaysInFirstWeek(7);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int diffDateForDay(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int diffDateForDay(String date, String date1, String format) {
		return (int) ((getMillis(parseDate(date, format)) - getMillis(parseDate(date1, format))) / (24 * 3600 * 1000));
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int diffDateForHour(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (3600 * 1000));
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int diffDateForMinute(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (60 * 1000));
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int diffDateForSecond(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / 1000);
	}
	
}
