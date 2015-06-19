package org.javacore.collection.set;

import java.util.Arrays;
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
 * 	Set的Contains方法
 */
public class SetContainT {
	public static void main(String[] args) {
		HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1,2,3));
		HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(4,2,5));
		
		System.out.println(getUnion(s1, s2));
	}
	
	/**
	 * 获取Set中不同对象的个数
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int getUnion(Set<?> s1,Set<?> s2){
		int count = s1.size();
		for( Object obj : s2){
			if (!s1.contains(obj))
				count++;
		}
		return count;
	}
}
