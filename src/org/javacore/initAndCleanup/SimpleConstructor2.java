package org.javacore.initAndCleanup;
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
 * @since 2015-9-7 16:54:19
 * 带参数简单构造器的展示
 */
public class SimpleConstructor2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Child2(i);
		}
	}
}

// Child类
class Child2 {
	Child2(int i) {// 带参数的Child类构造器
		System.out.print("Child init " + i + " ");
	}
}