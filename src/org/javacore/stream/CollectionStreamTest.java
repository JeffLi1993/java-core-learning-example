package org.javacore.stream;

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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream API 集合的流式操作
 *
 * Created by bysocket on 16/7/13.
 */
public class CollectionStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("cccc");
        list.add("bbb");

        /**
         * Stream的使用:
         *  创建/获取流 -> 中间操作（过滤、转换等） -> 终止操作（ 聚合、收集结果）
         */
        list.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 过滤
         *      collect语法 {@link StreamCollectTest}
         */
        List list0 = list.stream().filter(str -> str.startsWith("cc")).collect(Collectors.toList());
        List list1 = list.stream().filter(str -> str.startsWith("aa")).collect(Collectors.toList());

        list0.stream().forEach(System.out::println);
        list1.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 转换
         */
        List list2 = list.stream().map(str -> str.replace("c","*")).collect(Collectors.toList());

        list2.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 提取
         *      从skip开始至limit位置为止
         */
        List list3 = list.stream().skip(0).limit(1).collect(Collectors.toList());

        list3.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 组合
         */
        List list4 = Stream.concat(list.stream(),list.stream()).collect(Collectors.toList());

        list4.stream().forEach(System.out::println);
        System.out.println();
    }
}
