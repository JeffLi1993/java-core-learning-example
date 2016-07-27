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
import java.util.stream.Stream;

/**
 * 组合 - 流
 *
 * Created by bysocket on 16/7/14.
 */
public class ConcatStreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a","b","c");
        List<String> list2 = Arrays.asList("d","e","f");

        // 组合list1和list2的流
        List result = Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }
}
