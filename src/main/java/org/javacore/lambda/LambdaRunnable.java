package org.javacore.lambda;

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
 * Lambda - 启动线程
 *
 * Created by bysocket on 16/7/13.
 */
public class LambdaRunnable {
    static int b = 10;

    public static void main(String[] args) {
        // 启动线程
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                b++;
//                System.out.println(b);
//            }
//        });

        // Lambda - 启动线程
        Thread thread = new Thread(() -> {
            b++;
            System.out.println(b);
        });
        thread.start();
        System.out.println("Done!");
    }
}
