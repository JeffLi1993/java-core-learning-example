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
 * @since 2015-7-20 13:31:41
 * 类名过滤器的使用
 */
public class FilenameFilterT {

	public static void main(String[] args) {
		// IO包路径
		String dir = "src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io";
		File file = new File(dir);
		// 创建过滤器文件
		MyFilter filter = new MyFilter("y.java");
		// 过滤
		String files[] = file.list(filter);
		
		// 打印
		for (String name : files) {
			System.err.println(name);
		}
	}
	
	/**
	 *	内部类实现过滤器文件接口
	 */
	static class MyFilter implements FilenameFilter {
		
		private String type;
		
		public MyFilter (String type) {
			this.type = type;
		}

		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(type);// 以Type结尾
		}
		
	}
}
