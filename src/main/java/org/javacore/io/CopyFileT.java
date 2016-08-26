package org.javacore.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
 * @since 2015-8-11 11:44:59
 * 文件复制
 */
public class CopyFileT {
	public static void main(String[] args) throws IOException {
		String dir = "src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io";
		
		copyFile(dir + File.separator + "/CopyFileT.java", "D://Copy.java");
	}
	
	public static void copyFile(String srcFile,String destFile) 
		throws IOException {
		copyFile(new File(srcFile), new File(destFile));
	}
	
	public static void copyFile(File srcFile,File destFile)
		throws IOException {
		// 文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		// 文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] bytes = new byte[2 * 1024];
		int b;
		while ((b=in.read(bytes, 0, bytes.length)) != -1) {
			out.write(bytes, 0, b);
			out.flush();
		}
		out.close();
		in.close();
	}
}