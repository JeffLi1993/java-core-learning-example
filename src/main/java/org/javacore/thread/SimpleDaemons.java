package org.javacore.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by BYSocket on 2015/11/2.
 *
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
/**
 * @author Jeff Lee
 * @since 2015-11-3 18:09:06
 * 	Daemon后台线程的简单使用
 */
public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MICROSECONDS.sleep(1000);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    // main是非后台线程
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i < 10 ; i++){
            // 创建一个新线程
            Thread daemon = new Thread(new SimpleDaemons());
            // 设置为后台线程
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("所有任务已启动");
        // 如果main结束，那么同时会杀死所有后台线程,多次运行你会发现，可能打印的后台线程数不定
        TimeUnit.MICROSECONDS.sleep(175);
    }
}
