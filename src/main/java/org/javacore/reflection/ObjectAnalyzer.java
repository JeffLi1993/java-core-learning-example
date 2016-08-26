package org.javacore.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

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
 * 反射对象分析工具 @{link test/org.javacore.reflection.ObjectAnalyzerTest}
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj){
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);

        // 获取Class对象
        Class cl = obj.getClass();
        if (cl == String.class) return (String)obj;
        // 如果对象是一个数组类
        if (cl.isArray()){
            // 获取数组组件
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj,i);
                // 是否是一个基本类型
                if (cl.getComponentType().isPrimitive())
                    r += val;
                else  r += toString(val);
            }
            return r + "}";
        }

        String r =cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field f : fields){
                if (!Modifier.isStatic(f.getModifiers())){
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive())
                            r += val;
                        else
                            r +=toString(val);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }


}