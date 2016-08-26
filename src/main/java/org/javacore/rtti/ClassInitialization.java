package org.javacore.rtti;

import java.util.Random;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-11-2 16:43:41
 * 	Class初始化案例
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random random = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        // 类中有编译期常量 static Final,则暂时不需要初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        // 调用非编译期常量，强制进行类Initable初始化
        System.out.println(Initable.staticFinal2);

        // 先进行初始化
        System.out.println(Initable2.staticNonFinal);

        // 无编译期常量，直接初始化
        Class initable3 = Class.forName("org.javacore.rtti.Initable3");
        System.out.println("After creating Initable ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
