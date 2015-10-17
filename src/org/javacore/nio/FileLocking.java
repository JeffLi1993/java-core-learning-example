package org.javacore.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

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
 * @since 2015-10-15 19:31:34
 * 文件加锁
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 获取输出流
        FileOutputStream fos = new FileOutputStream("data.txt");
        // 从输出流中获取文件加锁对象，并锁定File
        FileLock fl = fos.getChannel().lock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MICROSECONDS.sleep(100);
            // 释放文件锁定
            fl.release();
            System.out.println("Release Lock");
        }
    }
}
