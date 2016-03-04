package org.javacore.thread.uncaughtexp;

/**
 * 描述:抛出运行时异常的线程类
 * Created by bysocket on 16/3/4.
 */
public class UncaughtTask implements Runnable {
    @Override
    public void run() {
        int numero = Integer.parseInt("TTTT");
    }
}
