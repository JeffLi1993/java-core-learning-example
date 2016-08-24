package org.javacore.time;

import java.time.LocalDate;

/**
 * Created by bysocket on 16/8/23.
 */
public class LocalDateTest {
	public static void main(String[] args) {
		// 今天的日期
		LocalDate localDate = LocalDate.now();

		System.out.println("今天:" + localDate);

		// 年
		System.out.println("年:" + localDate.getYear());
		// 月
		System.out.println("月:" + localDate.getMonth());
		System.out.println("月:" + localDate.getMonth());
		// 星期
		System.out.println("今天是星期" + localDate.getDayOfWeek());

		// 距离
		// 年
		System.out.println("今天是今年的第" + localDate.getDayOfYear() + "天");
		// 月
		System.out.println("今天是这个月的第" + localDate.getDayOfMonth() + "天");
	}
}
