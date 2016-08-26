package org.javacore.scheduler; /*
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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService的使用
 * @author BYSocket
 * @since 2016-01-10 14:20:00
 */
public class SchedulerExecutorTest implements
        Runnable {
    private final String jobName;

    public SchedulerExecutorTest(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("running => " + jobName);
    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        // 一秒
        executor.scheduleAtFixedRate(new SchedulerExecutorTest("job1"), 1, 1, TimeUnit.SECONDS);
        // 两秒
        executor.scheduleWithFixedDelay(new SchedulerExecutorTest("job2"),1,2,TimeUnit.SECONDS);
    }
}
