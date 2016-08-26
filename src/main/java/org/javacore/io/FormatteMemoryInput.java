package org.javacore.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
/**
 * @author Jeff Lee
 * @since 2015-7-15 20:42:47
 * 格式化内存输入
 */
public class FormatteMemoryInput {
	public static void main(String[] args) throws IOException {
		String filePath = "src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"FormatteMemoryInput.java";
		try {
			DataInputStream in = new DataInputStream(
					// 缓冲区字节输入
					new ByteArrayInputStream(
							BufferedInputFileT.read(filePath).getBytes()));
			while(true)
				System.out.println((char)in.readByte());
		} catch (EOFException e) {
			System.out.println("End of Stream");
		}
	}
}
