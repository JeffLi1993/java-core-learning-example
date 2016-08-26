package org.javacore.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

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
 * @since 2015-10-9 17:43:27
 *  FileChannel的transferTo/transferFrom案例
 */
public class FileChannelTransferTo {
	// 读取的文件
	private static final String sourceFile = 
			"src" + File.separator +
			"org" + File.separator +
			"javacore" + File.separator +
			"nio" + File.separator +
			"FileChannelTransferTo.java";
	// 输出的文件
	private static final String targetFile = "data.txt";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建用于读写的Channel
		FileChannel
			in  = new FileInputStream(sourceFile).getChannel(),
			out = new FileOutputStream(targetFile).getChannel();
		// 将in通道的字节传输给out可写入字节通道
		in.transferTo(0, in.size(),out);
		// or
		// 将字节从给定的可读取字节通道传输到此通道的文件中。
		// out.transferFrom(in, 0, in.size());
	}
}
