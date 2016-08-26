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
 * @since 2015-6-19 21:26:09
 * 	Integer与byte数组转换
 */
public class IntegerConvertT {
	
	public static void main(String[] args){
		// 将我的学号转换成字节码
		byte[] bytes = IntegerConvertT.int2Bytes(1206010035);
		System.out.println(bytes[0] + " " + bytes[1] + " " + bytes[2] + " " + bytes[3]);
		// 字节码就可以转换回学号
		System.out.println(IntegerConvertT.bytes2Int(bytes));
	}
	
	/**
	 * Int转字节数组
	 */
	public static byte[] int2Bytes(int inta){
		// 32位Int可存于长度为4的字节数组 
		byte[] bytes = new byte[4];
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = (byte)(int)((inta >> i * 8) & 0xff);// 移位和清零
		
		return bytes;
	}
	
	/**
	 * 字节数组转Int
	 */
	public static int bytes2Int(byte[] bytes){
		int inta = 0;
		for (int i = 0; i < bytes.length; i++)
			inta += (int)((bytes[i] & 0xff) << i * 8);// 移位和清零
		
		return inta;
	}
	
}
