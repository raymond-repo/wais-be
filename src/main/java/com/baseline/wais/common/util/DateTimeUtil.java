package com.baseline.wais.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeUtil {

	private static final Logger lOGGER = LoggerFactory.getLogger(DateTimeUtil.class);

	private static final String YEAR = "yyyy";
	private static final String MONTH = "MM";
	private static final String DAY = "dd";
	private static final String YEAR_MONTH_DAY = "yyyyMMdd";
	private static final String YEAR_MONTH_DAY_TIME = "yyyyMMdd HH:mm:ss";

	public static LocalDateTime getCurrentLocalDateTime() {
		return LocalDateTime.now();
	}

	public static String formatLocalDateTime(LocalDateTime localDateTime, String format) {
		if (ObjectUtil.isNotNull(localDateTime) && StringUtil.isNotEmpty(format)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
			return dateTimeFormatter.format(localDateTime);
		}
		return null;
	}

	public static String getCurrentDateTime() {
		return formatLocalDateTime(getCurrentLocalDateTime(), YEAR_MONTH_DAY_TIME);
	}

	public static String getCurrentDateString() {
		return formatLocalDateTime(getCurrentLocalDateTime(), YEAR_MONTH_DAY);
	}

	public static String getCurrentYearString() {
		return formatLocalDateTime(getCurrentLocalDateTime(), YEAR);
	}

	public static String getCurrentMonthString() {
		return formatLocalDateTime(getCurrentLocalDateTime(), MONTH);
	}

	public static String getCurrentDayString() {
		return formatLocalDateTime(getCurrentLocalDateTime(), DAY);
	}

	public static int getCurrentDateInt() {
		return Integer.valueOf(formatLocalDateTime(getCurrentLocalDateTime(), YEAR_MONTH_DAY));
	}

	public static int getCurrentYearInt() {
		return Integer.valueOf(getCurrentYearString());
	}

	public static int getCurrentMonthInt() {
		return Integer.valueOf(getCurrentMonthString());
	}

	public static int getCurrentDayInt() {
		return Integer.valueOf(getCurrentDayString());
	}

	public static String transformDate(String date, String dateFormatFrom, String dateFormatTo) {

		if (StringUtil.isNotEmpty(date) && StringUtil.isNotEmpty(dateFormatFrom)
				&& StringUtil.isNotEmpty(dateFormatTo)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatFrom);
			try {
				java.util.Date dateValue = simpleDateFormat.parse(date);
				simpleDateFormat = new SimpleDateFormat(dateFormatTo);
				return simpleDateFormat.format(dateValue);
			} catch (ParseException e) {
				lOGGER.error(e.getMessage());
			}
		}
		return null;
	}

	public static java.util.Date convertStringToUtilDate(String date, String dateFormat) {
		if (StringUtil.isNotEmpty(date)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			try {
				return simpleDateFormat.parse(date);
			} catch (ParseException e) {
				lOGGER.error(e.getMessage());
			}
		}
		return null;
	}

	public static java.sql.Date convertStringToSqlDate(String date) {
		if (StringUtil.isNotEmpty(date)) {
			return java.sql.Date.valueOf(date);
		}
		return null;
	}

	public static java.util.Date getCurrentDateUtilDate() {
		return new java.util.Date();
	}

	public static java.sql.Date getCurrentDateSqlDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

}
