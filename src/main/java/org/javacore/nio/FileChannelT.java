package org.javacore.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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
 * @since 2015-7-23 17:50:18
 * FileChannel读写文件案例
 */
public class FileChannelT {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// NIO包路径
		String dir = "src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"nio";
		// 获取FileChannelT.java文件，读写方式
		RandomAccessFile inFile = new RandomAccessFile(dir + File.separator + 
				"FileChannelT.java","rw");
		// 创建输出文件流
		FileOutputStream outFileStream = new FileOutputStream("D:\\FileChannelT2.java");
		// 创建输入文件通道
		FileChannel inChannel = inFile.getChannel();
		// 创建输出文件通道
		FileChannel outChannel = outFileStream.getChannel();
		// 分配一个1024字节的字节缓存区
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024); // 比allocate();效率高
		
		// 测试时间
		long startTime = System.currentTimeMillis();
		
		// 读文件，存文件
		while (true) {
			// 将字节序列从此通道读入给定的缓冲区
			int eof = inChannel.read(byteBuffer);
			// 读到文件末尾退出
			if (eof == -1) 
				break;
			// 反转缓冲区
			byteBuffer.flip();
			// 将字节序列从给定的缓冲区写入此通道
			outChannel.write(byteBuffer);
			// 清空缓存区
			byteBuffer.clear();
		}
		inChannel.close();
		outChannel.close();
		
		System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
	}

}
