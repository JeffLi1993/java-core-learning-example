package org.javacore.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 基于 JDK 8 time包的时间工具类
 * <p/>
 * Created by bysocket on 16/8/23.
 */
public class TimeUtil {

	/** 默认时间格式 */
	private static final String SHORT_DATE_PATTERN_DEFAULT				= "yyyy-MM-dd";
	private static final String LONG_DATE_PATTERN_DEFAULT				= "yyyy-MM-dd HH:mm:ss";
	private static final String LONG_DATE_PATTERN_WITH_MILSEC_DEFAULT	= "yyyy-MM-dd HH:mm:ss.SSS";

	/** 短时间格式  : 2016-08-25 */
	private static final String[] SHORT_DATE_PATTERN 				= { "yyyy-MM-dd",
																		"yyyy/MM/dd",
																		"yyyy\\MM\\dd",
																		"yyyyMMdd"};
	/** 长时间格式  : 2016-08-25 20:28:46 */
	private static final String[] LONG_DATE_PATTERN 				= {"yyyy-MM-dd HH:mm:ss",
																		"yyyy/MM/dd HH:mm:ss",
																		"yyyy\\MM\\dd HH:mm:ss",
																		"yyyyMMddHHmmss"};
	/** 长时间格式 ( 带毫秒 )  : 2016-08-25 20:34:48.956 */
	private static final String[] LONG_DATE_PATTERN_WITH_MILSEC 	= { "yyyy-MM-dd HH:mm:ss.SSS",
																		"yyyy/MM/dd HH:mm:ss.SSS",
																		"yyyy\\MM\\dd HH:mm:ss.SSS",
																		"yyyyMMddHHmmssSSS"};

	/**
	 * String 转时间
	 *
	 * @param timeStr
	 * @return
	 */
	public final static LocalDateTime parseTime(String timeStr) {
		LocalDateTime dateTime = LocalDateTime.parse(timeStr,getDefaultDateTimeFormatter());
		return dateTime;
	}

	/**
	 * String 转时间
	 *
	 * @param timeStr
	 * @param format 时间格式
	 * @return
	 */
	public final static LocalDateTime parseTime(String timeStr, String format) {
		LocalDateTime dateTime = LocalDateTime.parse(timeStr,getDateTimeFormatter(format));
		return dateTime;
	}

	/**
	 * 时间转 String
	 *
	 * @param time
	 * @return
	 */
	public final static String parseTime(LocalDateTime time) {
		return getDefaultDateTimeFormatter().format(time);
	}

	/**
	 * 时间转 String
	 *
	 * @param time
	 * @param format 时间格式
	 * @return
	 */
	public final static String parseTime(LocalDateTime time, String format) {
		return getDateTimeFormatter(format).format(time);
	}

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public final static String getCurrentDatetime() {
		LocalDateTime now = LocalDateTime.now();
		return getDefaultDateTimeFormatter().format(now);
	}

	/**
	 * 获取当前时间
	 *
	 * @param format 时间格式
	 * @return
	 */
	public final static String getCurrentDatetime(String format) {
		LocalDateTime now = LocalDateTime.now();
		return getDateTimeFormatter(format).format(now);
	}

	/**
	 * 获取默认时间格式
	 *
	 * @return
	 */
	private final static DateTimeFormatter getDefaultDateTimeFormatter() {
		return DateTimeFormatter.ofPattern(LONG_DATE_PATTERN_DEFAULT);
	}

	/**
	 * 获取时间格式
	 *
	 * @param format 时间格式
	 * @return
	 */
	private final static DateTimeFormatter getDateTimeFormatter(String format) {
		return DateTimeFormatter.ofPattern(format);
	}

	public static void main(String[] args) {
		// 当前时间
		System.out.println(getCurrentDatetime(SHORT_DATE_PATTERN_DEFAULT));
		System.out.println(getCurrentDatetime());
		System.out.println(getCurrentDatetime(LONG_DATE_PATTERN_WITH_MILSEC_DEFAULT));

		// 时间转 String
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(parseTime(dateTime));

		LocalDateTime dateTime1 = LocalDateTime.of(2016,8,25,23,10,10);
		System.out.println(parseTime(dateTime1,LONG_DATE_PATTERN_DEFAULT));

		// String 转时间
		String dateTimeStr = "2016-08-25 23:10:10";
		System.out.println(parseTime(dateTimeStr));

		String dateTimeStr1 = "2016-08-25 23:10:10";
		System.out.println(parseTime(dateTimeStr1,LONG_DATE_PATTERN_DEFAULT));
	}
}
