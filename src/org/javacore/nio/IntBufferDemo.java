package org.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

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
 * @since 2015-10-12 18:53:01
 *  通过IntBuffer操作ByteBuffer的int型数据
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;// 1字节
    public static void main(String[] args) {
        // 创建1字节大小的字节缓冲区
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // int视图缓冲区
        IntBuffer ib = bb.asIntBuffer();
        // 存储一个数组
        ib.put(new int[]{1, 2, 3, 4, 5, 6});
        // 通过访问ByteBuff字节缓冲区，获取某个位置的值
        System.out.println(ib.get(3));
        // 存储一个int数据
        ib.put(3, 44);
        // 反转缓冲区
        ib.flip();
        // 如果当前位置还有元素
        while (ib.hasRemaining()) {
            // 获取当前位置的元素
            int i = ib.get();
            System.out.println(i);
        }
    }
}
