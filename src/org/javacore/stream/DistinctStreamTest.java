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
 * 去重
 *
 * Created by bysocket on 16/7/14.
 */
public class DistinctStreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a","b","b","b","ac");

        // 去重
        List result = list1.stream().distinct().collect(Collectors.toList());
        result.stream().forEach(str -> System.out.print(str + " -> "));
    }
}
