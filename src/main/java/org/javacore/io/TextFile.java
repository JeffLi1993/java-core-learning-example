package org.javacore.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

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
 * @since 2015-9-30 16:10:18
 * 文本文件的操作案例
 */
public class TextFile extends ArrayList<String> {

	private static final long serialVersionUID = -6710557138987846943L;

	// 读取文件内容，返回内容字符串
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			// 创建缓存字符输入流
			BufferedReader in = new BufferedReader(new FileReader(// 创建读取字符文件类
					new File(fileName).getAbsolutePath()));// 文件绝对路径地址
			try {
				String s;
				// 读取一个文本行
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	// 将字符串写入一个文本文件
	public static void write(String fileName,String text) {
		try {
			// 创建打印输出流
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsolutePath());
			try {
				// 写入字符流
				out.write(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// 通过正则匹配，读取文件
	public TextFile(String fileName,String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		// 移除一个空格位置
		if (get(0).equals("")) remove(0);
	}
	
	public TextFile(String fileName) {
		this(fileName, "\n");
	}
	
	// 写入一个文本文件
	public void write(String fileName) {
		try {
			// 创建打印输出流
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsolutePath());
			try {
				for (String  item : this)
					out.write(item);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void main(String[] args) {
		// 读取文件
		String file = read("src/org/javacore/io/TextFile.java");
		// 写入到test.txt
		write("test.txt", file);
		
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		
		TreeSet<String> words = new TreeSet<>(
				new TextFile("src/org/javacore/io/TextFile.java","\\W+"));
		System.out.println(words.headSet("a"));
		
	}
}
