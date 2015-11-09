package org.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
 * 反射对象构造函数、方法及字段
 */
public class ReflectionTest {
    public final int  AGE = 1;
    public static void main(String[] args) {
        Class cl = null;
        try {
            cl = Class.forName("org.javacore.reflection.ReflectionTest");
            System.out.println("打印析构函数：");
            printConstructors(cl);
            System.out.println("打印方法：");
            printMethods(cl);
            System.out.println("打印字段：");
            printFields(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印Class对象的析构方法
     * @param cl
     */
    public static void printConstructors(Class cl){
        // 返回类所有的析构方法
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors){
            // 返回析构方法名称
            String name = c.getName();
            System.out.print("   ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // 获取析构方法的参数对象列表数组
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length;i++){
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印对象所有的方法
     * @param cl
     */
    public static void printMethods(Class cl){
        // 获取类所有方法对象数组
        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            // 获取方法返回对象
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() +" " + name + "(");

            // 获取方法的参数对象列表数组
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length;i++){
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class clazz){
        // 获取字段Field对象数组
        Field[] fields = clazz.getFields();
        for (Field field : fields){
            // 获取字段声明类型对象
            Class type = field.getType();
            // 获取字段名称
            String name = field.getName();

            System.out.print("   ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(type.getName() + " " + name);
        }
    }
}
