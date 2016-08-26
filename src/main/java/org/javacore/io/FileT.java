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
 * @since 2015-6-30 14:21:47
 * File类的使用
 */
public class FileT {

	public static void main(String[] args) {
		try {
			// 创建一个目录
			File dir = new File("E:" + File.separator + "dir");
			dir.mkdir();
			// 创建一个文件
			File file = new File(dir,"file.txt");
			file.createNewFile();
			
			// 是否是一个目录
			System.out.println(dir.isDirectory());
			// 是否是一个文件
			System.out.println(file.isFile());
			
			// 删除文件
			if (file.delete()) {
				System.out.println(file.getName() + "被删除了！");
			} else {
				System.out.println("文件删除失败！");
			}
		} catch (IOException e) { e.printStackTrace(); }
	}

}
