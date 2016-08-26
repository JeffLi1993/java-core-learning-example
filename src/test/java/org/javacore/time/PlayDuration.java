package org.javacore.time;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * 持续时间类 Duration
 *
 * Created by bysocket on 16/8/23.
 */
public class PlayDuration {
	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		TimeUnit.SECONDS.sleep(3);
		Instant end   = Instant.now();

		// 获取持续时间
		Duration timeElapsed = Duration.between(start,end);
		System.out.println(timeElapsed.toMillis());// 毫秒
		System.out.println(timeElapsed.toNanos());// 纳

		Instant start1 = Instant.now();
		TimeUnit.SECONDS.sleep(2);
		Instant end1   = Instant.now();

		// 获取持续时间
		Duration timeElapsed1 = Duration.between(start1,end1);

		// 添加操作
		Duration all = timeElapsed.plus(timeElapsed1);
		System.out.println(all.toMillis());// 毫秒
	}
}
