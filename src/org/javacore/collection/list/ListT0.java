package org.javacore.collection.list; /*
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
import java.util.ListIterator;

/**
 * @author BYSocket
 * @since 2016-01-06 20:11:00
 *  打印list 全部元素，并找到其中元素aaa删除。要求：所有元素都遍历完
 *          ListIterator 的使用
 *  list那个remove回抛异常是因为快速失败的机制，
 *  他内置了一个modifyCount的变量记录list的长度变化，用Iter可以删除掉
 */
public class ListT0 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("aaa");
        list.add("6");
        list.add("7");

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object o = listIterator.next();
            System.out.println(o);
            if (o.equals("aaa")) {
                listIterator.remove();
            }
        }
    }

}
