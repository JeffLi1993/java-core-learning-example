package org.javacore.base.String; /*
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
 * @author BYSocket
 * @since 2016-01-06 19:51:00
 *  常见面试题：String作为方法参数传递,另外一个例子 ${@link StringT2}
 *  这就叫做“值传递”，即方法操作的是参数变量（也就是原型变量的一个值的拷贝）
 *  改变的也只是原型变量的一个拷贝而已，而非变量本身
 */
public class StringT {
    public static void main(String[] args) {
        String str = "123";
        change(str);
        System.out.println(str);
    }

    public static void change(String str) {
        str = "456";
    }
}
