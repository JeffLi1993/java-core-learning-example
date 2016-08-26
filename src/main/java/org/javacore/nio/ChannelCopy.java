package org.javacore.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
 * @since 2015-10-9 17:38:08
 * 	FileChannel的文件复制案例
 */
public class ChannelCopy {
	// 读取的文件
	private static final String sourceFile = 
			"src" + File.separator +
			"org" + File.separator +
			"javacore" + File.separator +
			"nio" + File.separator +
			"ChannelCopy.java";
	// 输出的文件
	private static final String targetFile = "data.txt";
	
	private static final int BSIZE = 1024; // 1K字节
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建用于读写的Channel
		FileChannel 
			in  = new FileInputStream(sourceFile).getChannel(),
			out = new FileOutputStream(targetFile).getChannel();
		
		// 分配ByteBuffer的大小 1K
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		// 将字节序列从此通道读入给定的缓冲区,分块读，直至读到文件末端
		while (in.read(buffer) != -1) {// -1,表示读到文件末端
			// 反转缓冲区，为写入或读取做好准备
			buffer.flip();
			// 将含有字节序列的缓冲区写入文件通道
			out.write(buffer);
			// 清空缓冲区
			buffer.clear();
		}
		
	}
}
