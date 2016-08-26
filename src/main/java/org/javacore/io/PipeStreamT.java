package org.javacore.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
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
 * @since 2015-7-30 21:58:18
 * 管道输入输出流的使用
 * 		同一个JVM中，两个线程直接的字节流通信
 */
public class PipeStreamT {
	public static void main(String[] args) throws IOException {
		// 创建管道输出流
		final PipedOutputStream output = new PipedOutputStream();
		// 创建管道输入流，并连接到管道输出流
		@SuppressWarnings("resource")
		final PipedInputStream  input  = new PipedInputStream(output);
		//final PipedInputStream  input  = new PipedInputStream();
		//input.connect(output); // 等价于
		
		Thread outputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 将指定的字节数组写入管道输出流
					output.write("Hello,PipedStream!".getBytes());
				} catch (IOException e) {}
			}
		});
		
		Thread inputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 读取管道输入流中的下一个数据字节
					int data = input.read();
					while( data != -1) {
						System.out.print((char) data);
						// 再次读取下一个字节
						data = input.read();
					}
				} catch (IOException e){}
			}
		});
		
		outputThread.start();
		inputThread.start();
	}
}
