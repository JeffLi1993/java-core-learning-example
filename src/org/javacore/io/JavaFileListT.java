package org.javacore.io;

import java.io.File;
import java.io.FilenameFilter;
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
 * @since 2015-7-13 21:13:58
 * FilenameFilter文件过滤器的使用
 */
public class JavaFileListT {
	
	// 文件过滤接口
	// 作为匿名内部类，变量type必须声明为final类型
	public static FilenameFilter javaFileFilter(final String type) {
		// 过滤接口-匿名内部类
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) { 
				return new File(name).getName().indexOf(type) != -1;
			}
		};
	}
	
	public static void main(String[] args) {
		// 创建一个目录
		File file = new File("src\\org\\javacore\\io");// 当前目录
		// 获取文件名数组
		String fileNames[] = file.list(javaFileFilter(".java"));
		// 打印
		for (String item : fileNames) {
			System.out.println(item);
		}
	}
}
