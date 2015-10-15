package org.javacore.nio;

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Jeff Lee
 * @since 2015-10-14 16:01:14
 * 内存映射文件的使用
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF; // 128 MB

    public static void main(String[] args) throws IOException {
        // 将此通道的文件区域直接映射到内存映射区域中。
        MappedByteBuffer out = new RandomAccessFile("data.txt","rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        // 写入128MB的字符串
        for (int i = 0;i < length; i++)
            out.put((byte)'x');
        System.out.println("Finished writing");
        // 打印其中6个字符
        for (int i = length/2; i < length/2 + 6; i++)
            System.out.print((char)out.get(i));
    }
}
