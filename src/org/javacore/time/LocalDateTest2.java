package org.javacore.time;

import java.time.LocalDate;

/**
 * 计算BYSocket的生日是今年的第几天
 *
 * Created by bysocket on 16/8/23.
 */
public class LocalDateTest2 {
	public static void main(String[] args) {
		LocalDate birthdayDate = LocalDate.of(2016,5,2);
		System.out.println("BYSocket的生日是今年的第" + birthdayDate.getDayOfYear() + "天");
		// 明年的生日
		System.out.println(birthdayDate.plusYears(1));
	}
}
