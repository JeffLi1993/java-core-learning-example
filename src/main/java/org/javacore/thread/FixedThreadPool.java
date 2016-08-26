package org.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
 * @since 2015-11-2 17:06:48
 * 	线程池FixedThreadPool的简单使用-启动LiftOff线程{@link LiftOff}
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // 创建固定线程为5的线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5 ;i++)
            exec.execute(new LiftOff());// 由线程池Ececutor决定执行给定的线程。
        // 顺序关闭，执行以前提交的线程，不接受新的线程。
        exec.shutdown();
    }
}
