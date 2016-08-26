package org.javacore.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
 * 缓冲输入文件
 */
public class BufferedInputFileT {
	
	/**
	 * 通过文件名，读取文件并缓冲
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String read(String filename) 
			throws IOException {
		// 通过行读取输入
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			sb.append(s + "\n");// 不考了线程安全，StringBuilder 比  StringBuffer效率高
		// 关闭文件
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] rags) throws IOException {
		// 缓冲输入文件，并打印
		System.out.println(read(
				"src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"BufferedInputFileT.java"));
	}
}
