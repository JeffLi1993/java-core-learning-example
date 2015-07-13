package org.javacore.io;

import java.io.File;
import java.util.Arrays;
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
 * @since 2015-7-13 07:58:56
 * 列出目录并排序
 */
public class DirListT {
	public static void main(String[] args) {
		// 获取当前目录
		File path = new File(".");// .表示当前目录
		// 文件路径名数组
		String list[] = path.list();
		
		// 对String文件名进行排序
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		
		// 打印
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}
