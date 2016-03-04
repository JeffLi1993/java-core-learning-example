package org.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by bysocket on 16/3/3.
 */
public class DSLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("begining the DSLoader");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DSLoader has finished");
    }
}
