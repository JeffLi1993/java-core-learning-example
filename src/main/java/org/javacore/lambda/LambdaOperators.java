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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 操作符
 *
 * Created by bysocket on 16/7/13.
 */
public class LambdaOperators {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("cccc");
        list.add("b");
        list.add("eeeee");

        /**
         * :: 操作符格式 => 三种情况
         *    对象::实例方法
         *    类::静态方法
         *    类::实例方法 对于前两种情况，方法引用就是对参数执行该方法。比如下面两种方法
         */
        // 按字符串大小排序忽略大小写
        list.sort(String::compareToIgnoreCase);
        // 打印 list 元素
        list.forEach(System.out::println);

        System.out.println("======按字符大小排序======");
        list.sort(Comparator.comparing(String::length));
        list.forEach(System.out::println);
    }
}
