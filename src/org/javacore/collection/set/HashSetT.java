package org.javacore.collection.set;

import java.util.HashSet;
import java.util.Set;
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
 * @since 2015-6-19 15:46:37
 * 	HashSet的Add方法
 */
public class HashSetT{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		Set h1 = new HashSet<String>();
		h1.add("List");
		h1.add(new String("List"));
		h1.add("List");
		h1.add("Set");
		h1.add("Queue");
		h1.add("Map");
		// 注意排序
		System.out.println("HashSet Elements:");
		System.out.print("\t" + h1 + "\n");
	}
}
