package org.javacore.collection.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
 * @since 2015-6-19 16:03:10
 * 	Collections.EMPTY_MAP 与 new HashMap 性能对比
 * 场景：webservice接口，根据某些条件直接返回空Map，则使用Collections.EMPTY_MAP。
 */
public class PerBtwnEmptyMapAndHashMapT {
	@SuppressWarnings({"unused", "rawtypes"})
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long endTime;
		long duration; 
		for (int i = 0; i < 100000000; i++) {
			Map map = Collections.EMPTY_MAP;
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Collections.EMPTY_MAP:  " + duration);
		
		startTime = System.nanoTime();
		for (int i = 0; i < 100000000; i++) {
			Map map = new HashMap<>();
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("new HashMap:  " + duration);
	}
}
