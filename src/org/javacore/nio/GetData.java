package org.javacore.nio;

import java.nio.ByteBuffer;

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
 * @since 2015-10-12 18:53:10
 *  ByteBuffer操作类型数据的案例
 */
public class GetData {
    private static final int BSIZE = 1024; // 1字节
    public static void main(String[] args) {
        // 创建字节缓冲区
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit())// 缓冲区的限制
            if (bb.get() != 0)// 读取当前位置字节，如果字节不等于0
                System.out.println("该字节不为0");
        // 读取到最后一个跳出限制while，i为BSIZE大1。
        System.out.println("i = " + i);

        // 重绕此缓冲区
        bb.rewind();
        // 写入Hello
        bb.asCharBuffer().put("Hello");
        // 从缓冲区读取char，并输出
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();

        // 写入Short类型数据
        bb.asShortBuffer().put((short) 47142);
        System.out.println(bb.getShort());
        // 重绕此缓冲区
        bb.rewind();

        // 写入Long类型数据
        bb.asLongBuffer().put((long)99471142);
        System.out.println(bb.getLong());
        // 重绕此缓冲区
        bb.rewind();
    }
}
