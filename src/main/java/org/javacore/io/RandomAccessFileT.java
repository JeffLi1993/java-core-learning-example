package org.javacore.io;
import java.io.IOException;
import java.io.RandomAccessFile;
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
 * @since 2015-7-14 08:54:24
 * RandomAccessFile的使用
 */
public class RandomAccessFileT {
	public static void main(String[] args) throws IOException {
		// 获取文件，读写方式
		RandomAccessFile file = new RandomAccessFile("D:\\data\\file.txt","rw");
		
		// 设置文件指针位置
		file.seek(6);
		// 文件中的当前偏移量
		System.out.println(file.getFilePointer());
		
		// 读取文本的一行
		System.out.println((char)file.read());// int字节，转char显示
		
		// 写入字节数组
		file.write("Hello World".getBytes());

		// 初始化文件指针位置
		file.seek(0);
		// 读取文本的一行
		System.out.println(file.readLine());
				
		file.close();
	}
}
