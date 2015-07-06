package org.javacore.thread;
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
 * @since 2015-7-4 16:15:38
 * 	Thread的简单实用测试 {@link MyThread}
 */
public class MyThreadTest {
	public static void main(String[] args) {
		// 创建线程
		MyThread mThread = new MyThread();
		// 启动线程
		mThread.start();
	}
}
