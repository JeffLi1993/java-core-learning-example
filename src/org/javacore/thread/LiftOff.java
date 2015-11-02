package org.javacore.thread;

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

/**
 * @author Jeff Lee
 * @since 2015-11-2 16:56:43
 * 	Runnable接口的实现类LiftOff
 */
public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" +
                (countDown >0 ? countDown : "LiftOff!") + "), ";
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            // 暂停当前正在执行线程，并执行其他线程。
            Thread.yield();
        }
    }
}
