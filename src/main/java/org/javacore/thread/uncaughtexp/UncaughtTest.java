package org.javacore.thread.uncaughtexp;

/**
 * 描述:实现异常类Test
 * Created by bysocket on 16/3/4.
 */
public class UncaughtTest {
    public static void main(String[] args) {
        UncaughtTask uncaughtTask = new UncaughtTask();
        Thread thread = new Thread(uncaughtTask);
        thread.setUncaughtExceptionHandler(new ExceptionHadler());
        thread.start();
    }
}
