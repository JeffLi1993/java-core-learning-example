package org.javacore.io;

import java.io.PrintWriter;
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
 * @since 2015-10-6 18:38:15
 * 改变System.out输出案例
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello PrintWriter");
		out.close();
	}
}
