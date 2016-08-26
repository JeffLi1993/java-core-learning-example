package org.javacore.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
 * @since 2015-11-2 18:58:36
 * 	Callable接口的使用 --- 实现带返回值的任务
 */

// Callable实现类task，指定其类型参数
class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        // 创建一个新的线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // Callable实现类task的返回结果集
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5 ; i++)
            results.add(exec.submit(new TaskWithResult(i)));// 使用submit来启动Tasks

        // 异步计算的结果
        for (Future<String> fs : results)
            try {
                // get阻塞，直至获取结果
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e);
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
    }
}