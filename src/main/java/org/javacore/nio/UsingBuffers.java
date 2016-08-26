package org.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

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
 * @since 2015-10-14 15:48:12
 * 利用buffer实现交换相邻字符
 */
public class UsingBuffers {

    private static void symmetricScaramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            // 将mark设为position
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            // 重置为以前标记的位置
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        // 一个字符两个字节
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        // 重绕此缓冲区
        System.out.println(cb.rewind());
        symmetricScaramble(cb);
        // 重绕此缓冲区
        System.out.println(cb.rewind());
        symmetricScaramble(cb);
        System.out.println(cb.rewind());
    }
}
