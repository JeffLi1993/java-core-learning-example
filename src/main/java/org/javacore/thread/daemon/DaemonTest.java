package org.javacore.thread.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1. 知道3个WriteTask线程休眠后,CleanerTask才执行
 * 2. 从结果中,可以看出队列维持在一定数量当中
 * Created by bysocket on 16/3/4.
 */
public class DaemonTest {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();
        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 3 ; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
