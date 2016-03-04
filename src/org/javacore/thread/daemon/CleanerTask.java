package org.javacore.thread.daemon;

import java.util.Date;
import java.util.Deque;

/**
 * 描述:管理这个队列,如果事件超过10秒钟,就会被移除
 * Created by bysocket on 16/3/4.
 */
public class CleanerTask extends Thread{
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    /**
     * 删除该时间前10s内创建的事件对象
     * @param date
     */
    private void clean(Date date) {
        long difference = 0;
        boolean delete;
        if (deque.size() == 0) {
            return;
        }
        delete = false;

        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000) {
                System.out.printf("Cleaner: %s \n",e.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > 10000);

        if (delete) {
            System.out.printf("Cleaner: Size of the queue: %d\n",deque.size());
        }
    }
}
