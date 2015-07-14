package org.javacore.io;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
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
 * 内存中输入
 */
public class MemoryInputT {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFileT.read(
				"src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"BufferedInputFileT.java"));
		int c;
		while((c = in.read()) != -1)// int形式
			System.out.println((char)c);// int字节，转char显示
	}
}
