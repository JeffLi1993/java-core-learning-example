package org.javacore.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

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
 * @since 2015-10-17 15:17:04
 * 映射文件的使用
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF; // 128 MB
    static FileChannel fc;

    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("data.txt" , "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE,
                0 , LENGTH);
        for (int i = 0;i < LENGTH; i++)
            out.put((byte)'x');
        new LockAndModify(out,0,0 + LENGTH/3);
        new LockAndModify(out,LENGTH/2,LENGTH/2 + LENGTH/4);
    }

    // 线程
    private static class LockAndModify extends Thread {
        private ByteBuffer buffer;
        private int start,end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buffer = mbb.slice();
            start();
        }

        public void run() {
            try {
                // 从FileChannel获取文件加锁对象，并加锁
                FileLock fl = fc.lock(start,end,false);
                System.out.println("Locked: " + start + " to " + end);
                // 写入数据
                while (buffer.position() < buffer.limit() - 1)
                    buffer.put((byte)(buffer.get() + 1));
                fl.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }
    }
}
