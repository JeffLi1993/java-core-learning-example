package org.javacore.time;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * Created by bysocket on 16/8/23.
 */
public class LocalDateTest1 {
	public static void main(String[] args) throws InterruptedException {
		LocalDate start = LocalDate.now();
		TimeUnit.SECONDS.sleep(3);
		LocalDate end   = LocalDate.now();

		System.out.println(start.isAfter(end));
		System.out.println(start.isBefore(end));
	}
}
