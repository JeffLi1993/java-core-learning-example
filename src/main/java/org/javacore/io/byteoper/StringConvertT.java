package org.javacore.io.byteoper;
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
 * @since 2015-6-19 21:27:41
 * 	String转换成byte数组
 */
public class StringConvertT {

	public static void main(String[] args){
		String str = "HOME";
		byte[] bytes = str.getBytes();
		// 打印字节数组
		System.out.println("UTF-8编码'HOME'的字节数组为：");
		for (int i = 0; i < bytes.length; i++) {
            System.out.println("\t" + bytes[i] + "|" + Integer.toBinaryString(bytes[i]));
        }
	}
}
