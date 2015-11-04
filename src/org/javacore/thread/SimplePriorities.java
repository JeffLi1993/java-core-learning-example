package org.javacore.thread;

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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jeff Lee
 * @since 2015-11-3 09:05:03
 * 	线程优先级的使用
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        // 获取当前执行的线程对象的引用
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        // 获取当前执行的线程对象的引用，并设置其优先级。
        Thread.currentThread().setPriority(priority);

        while (true){
            for (int i = 1; i < 100000; i++){
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        // 创建新的线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5 ;i++)
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));// 由线程池决定执行线程，并设置优先级最低
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));// 由线程池决定执行线程，并设置优先级最高
        // 顺序关闭，执行以前提交的线程，不接受新的线程
        exec.shutdown();
    }
}
