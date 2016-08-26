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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤
 * 流的元素数量
 *
 * Created by bysocket on 16/7/14.
 */
public class CountFilterStreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a","b","ac");

        // filter 过滤
        List result = list1.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
        result.stream().forEach(System.out::println);
        System.out.println();

        // count  流的元素数量
        long l = list1.stream().filter(str -> str.startsWith("a")).count();
        System.out.println("list1 字符从a开始的数量:" + l);

    }
}
