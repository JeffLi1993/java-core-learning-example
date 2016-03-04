package org.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by bysocket on 16/3/3.
 */
public class NetLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("begining the NetLoader");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NetLoader has finished");
    }
}
