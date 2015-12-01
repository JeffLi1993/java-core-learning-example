package org.javacore.base.inter;

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
 * @since 2015-12-1 13:04:30
 *  使用接口的接口案例
 */
interface ProcessorInter {
    String name();

    Object process(Object input);
}

class UpcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class SplitcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyInter {
    public static void process(ProcessorInter p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    public static String s = "BYSocket's Blog is www.bysocket.com";
    public static void main(String[] args) {
        process(new UpcaseImpl(),s);
        process(new SplitcaseImpl(),s);
    }
}
