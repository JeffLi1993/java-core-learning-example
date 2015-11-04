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
 * @since 2015-11-3 18:17:58
 * 	后台线程遇到Finally
 */
class ADaemon implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("启动ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e ){
            System.out.println("InterruptedException");
        } finally {
            // 因为main是非后台线程，main线程结束。ADaemon后台线程也就结束。因此可能没到finally就结束了。
            System.out.println("finally 运行吗？");
        }
    }
}
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        // 设置线程为后台线程
        t.setDaemon(true);
        t.start();
    }
}
