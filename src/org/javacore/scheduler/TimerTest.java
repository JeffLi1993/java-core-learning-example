package org.javacore.scheduler;
/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer的使用
 * @author BYSocket
 * @since 2016-01-09 22:19:00
 */
public class TimerTest extends TimerTask{

    private final String jobName;

    public TimerTest(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("run the task => " + jobName);
    }

    public static void main(String[] args) {
        // 一种工具，线程用其安排以后在后台线程中执行的任务
        Timer timer = new Timer();
        timer.schedule(new TimerTest("Job 1") , 1000 , 1000); // 一秒
        timer.schedule(new TimerTest("Job 2") , 2000 , 2000); // 两秒
    }
}
