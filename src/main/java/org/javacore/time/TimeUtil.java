package org.javacore.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 基于 JDK 8 time包的时间工具类
 * <p/>
 * Created by bysocket on 16/8/23.
 */
public final class TimeUtil {

	private TimeUtil() {
	}

	/**
	 * 时间间隔之间的空格
	 */
	private static final String SPACE_OF_TIME = " ";

	/**
	 * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
	 */
	private static final DateTimeFormatter defaultDateTimeFormatter = DateTimeFormatter.ofPattern(TimeFormat.LONG_DATE_PATTERN_LINE);

	/**
	 * String 转时间
	 *
	 * @param timeStr
	 * @return
	 */
	public final static LocalDateTime parseTime(String timeStr) {
		LocalDateTime dateTime = LocalDateTime.parse(timeStr, defaultDateTimeFormatter);
		return dateTime;
	}

	/**
	 * String 转时间
	 *
	 * @param timeStr
	 * @param format  时间格式
	 * @return
	 */
	public final static LocalDateTime parseTime(String timeStr, String format) {
		LocalDateTime dateTime = LocalDateTime.parse(timeStr, getDateTimeFormatter(format));
		return dateTime;
	}

	/**
	 * 时间转 String
	 *
	 * @param time
	 * @return
	 */
	public final static String parseTime(LocalDateTime time) {
		return defaultDateTimeFormatter.format(time);
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
		LocalDateTime now = LocalDateTime.now().withNano(0);
		return now.toLocalDate() + SPACE_OF_TIME + now.toLocalTime();
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
		System.out.println(getCurrentDatetime(TimeFormat.SHORT_DATE_PATTERN_LINE));
		System.out.println(getCurrentDatetime());
		System.out.println(getCurrentDatetime(TimeFormat.LONG_DATE_PATTERN_WITH_MILSEC_LINE));

		// 时间转 String
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(parseTime(dateTime));

		LocalDateTime dateTime1 = LocalDateTime.of(2016, 8, 25, 23, 10, 10);
		System.out.println(parseTime(dateTime1, TimeFormat.LONG_DATE_PATTERN_LINE));

		// String 转时间
		String dateTimeStr = "2016-08-25 23:10:10";
		System.out.println(parseTime(dateTimeStr));

		String dateTimeStr1 = "2016-08-25 23:10:10";
		System.out.println(parseTime(dateTimeStr1, TimeFormat.LONG_DATE_PATTERN_LINE));
	}
}

/**
 * 时间格式
 *
 */
class TimeFormat {

	/**
	 * 短时间格式
	 */
	public static final String SHORT_DATE_PATTERN_LINE = "yyyy-MM-dd";
	public static final String SHORT_DATE_PATTERN_SLASH = "yyyy/MM/dd";
	public static final String SHORT_DATE_PATTERN_DOUBLE_SLASH = "yyyy\\MM\\dd";
	public static final String SHORT_DATE_PATTERN_NONE = "yyyyMMdd";

	/**
	 * 长时间格式
	 */
	public static final String LONG_DATE_PATTERN_LINE = "yyyy-MM-dd HH:mm:ss";
	public static final String LONG_DATE_PATTERN_SLASH = "yyyy/MM/dd HH:mm:ss";
	public static final String LONG_DATE_PATTERN_DOUBLE_SLASH = "yyyy\\MM\\dd HH:mm:ss";
	public static final String LONG_DATE_PATTERN_NONE = "yyyyMMdd HH:mm:ss";

	/**
	 * 长时间格式 带毫秒
	 */
	public static final String LONG_DATE_PATTERN_WITH_MILSEC_LINE = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String LONG_DATE_PATTERN_WITH_MILSEC_SLASH = "yyyy/MM/dd HH:mm:ss.SSS";
	public static final String LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH = "yyyy\\MM\\dd HH:mm:ss.SSS";
	public static final String LONG_DATE_PATTERN_WITH_MILSEC_NONE = "yyyyMMdd HH:mm:ss.SSS";
}