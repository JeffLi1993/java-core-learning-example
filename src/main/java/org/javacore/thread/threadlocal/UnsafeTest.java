package org.javacore.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 描述:可以看到线程每个有不同的启动时间,但是结束时间会有相同.
 * Created by bysocket on 16/3/8.
 */
public class UnsafeTest {
    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0 ; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
