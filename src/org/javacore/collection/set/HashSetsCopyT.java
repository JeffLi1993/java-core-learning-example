package org.javacore.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
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
 * @since 2015-6-18 21:02:07
 * 	HashSet及其子类的转换使用
 */
public class HashSetsCopyT{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		Set s1 = new HashSet<String>();
		s1.add("List");
		s1.add("Queue");
		s1.add("Set");
		s1.add("Map");
		
		System.out.println("HashSet Elements:");
		System.out.print("\t" + s1 + "\n");
		
		Set s2 = copy(s1);
		System.out.println("HashSet Elements After Copy:");
		System.out.print("\t" + s2 + "\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set copy(Set set)	{
		Set setCopy = new LinkedHashSet(set);
		return setCopy;
	}
}
