package org.javacore.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

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
 * @since 2015-11-9 10:45:19
 * 反射扩容对象数组
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] str = {"a","b","c"};
        str = (String[]) goodCopyOf(str,10);
        System.out.println(Arrays.toString(str));
    }

    public static Object goodCopyOf(Object a,int newLength){
        // 获取Class对象
        Class cl = a.getClass();
        // 如果不是数组对象，则返回null;
        if (!cl.isArray()) return null;
        // 获取数组组件对象
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        // 复制数组
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
