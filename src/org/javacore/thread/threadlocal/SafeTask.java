package org.javacore.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 描述:看类里面说明
 * Created by bysocket on 16/3/8.
 */
public class SafeTask implements Runnable{
    /**
     * ThreadLocal对象不会被所有线程共享
     * --> 线程局部变量 <--
     */
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        /**
         * 隐式实现初始化对象
         * @return
         */
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finish Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
