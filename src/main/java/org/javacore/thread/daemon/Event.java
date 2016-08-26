package org.javacore.thread.daemon;

import java.util.Date;

/**
 * 描述:事件类
 * Created by bysocket on 16/3/4.
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
