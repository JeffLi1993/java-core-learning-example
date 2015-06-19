package org.javacore.collection.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
 * @since 2015-6-17 23:32:30
 * 	Collections的使用
 */
public class CollectionsT{
	public static void main(String[] args){
		// 测试集合工具类Sort方法
		testSort();
	}
	
	/**
	 * 测试集合工具类Sort方法
	 */
	private static void testSort(){
		List<Integer> teams = new ArrayList<Integer>();
		teams.add(1);
		teams.add(3);
		teams.add(2);
		teams.add(4);
		// 调用集合工具类Sort方法
		Collections.sort(teams);
		
		System.out.println("Teams:");
		System.out.print("\t" + teams + "\n");
	}
}
