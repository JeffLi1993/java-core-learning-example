package org.javacore.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
 * @since 2015-10-6 18:40:24
 *  操作系统进程流的案例
 */
public class OSExecuteT {
	public static void commond(String command) {
		boolean err = false;
		
		try {
			// 创建操作系统进程
			Process process = 
					new ProcessBuilder(command.split(" ")).start();
			
			// 读取进程的输入流
			BufferedReader results = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = results.readLine()) != null)
				System.out.println(s);
			
			// 读取进程的错误流
			BufferedReader errors = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			while ((s = errors.readLine()) != null) {
				System.err.println(s);
				if (!err)
					err = true;
			}
			
		} catch (Exception e) {
			if (!command.startsWith("CMD /C"))
				commond("CMD /C " + command);
			else 
				throw new RuntimeException(e);
		}
		
		if (err)
			throw new OSExecuteException("Errors Executing " + command);
	}
	
	public static void main(String[] args) {
		commond("java -version");
	}
}
class OSExecuteException extends RuntimeException {
	private static final long serialVersionUID = -3254218368058055219L;

	public OSExecuteException(String msg) {
		super(msg);
	}
}
