package org.javacore.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by bysocket on 16/2/24.
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread inThread = new Thread(new InterrupThread());
        inThread.start();
        Thread.sleep(1000);
        inThread.interrupt();
    }
}

class InterrupThread implements Runnable {

    private int num = 1;

    @Override
    public void run() {
        while (true) {
            System.out.println("true ----> " + num++);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("exit");
    }
}
