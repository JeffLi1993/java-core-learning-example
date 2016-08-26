package org.javacore.io;

import java.io.File;
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
 * @since 2015-7-13 10:06:28
 * File方法详细使用
 */
public class FileMethodsT {
	
	private static void fileData(File f) {
		System.out.println(
			" 绝对路径：" + f.getAbsolutePath() +
			"\n 可读：" + f.canRead() +
			"\n 可写：" + f.canWrite() +
			"\n 文件名：" + f.getName() +
			"\n 上级目录：" + f.getParent() +
			"\n 相对地址：" + f.getPath() +
			"\n 长度：" + f.length() +
			"\n 最近修改时间：" + f.lastModified()
			);
		if(f.isFile())
			System.out.println(" 是一个文件");
		else if(f.isDirectory())
			System.out.println(" 是一个目录");
	}
	
	public static void main(String[] args) {
		// 获取src目录
		File file = new File("src");
		// file详细操作
		fileData(file);
	}
}
