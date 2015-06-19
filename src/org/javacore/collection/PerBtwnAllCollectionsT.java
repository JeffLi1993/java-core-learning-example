package org.javacore.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
 * 	各集合添加元素性能对比
 */
@SuppressWarnings("unchecked")
public class PerBtwnAllCollectionsT{
	
	public static void main(String[] args){
		// List Add对比
		printLists();
		// Set Add对比
		printSets();
		// Map put对比
		printMaps();
	}

	/**
	 * 比较List的Add方法
	 */
	private static void printLists(){
		List<String> a1 = new ArrayList<String>();
		a1.add("List");
		a1.add("Set");
		a1.add("Queue");
		a1.add("Map");
		System.out.println("ArrayList Elements:");
		System.out.print("\t" + a1 + "\n");
		
		List<String> l1 = new LinkedList<String>();
		l1.add("List");
		l1.add("Set");
		l1.add("Queue");
		l1.add("Map");
		System.out.println("LinkedList Elements:");
		System.out.print("\t" + l1 + "\n");
	}
	
	/**
	 * 比较Set的Add方法:注意元素的位置
	 */
	@SuppressWarnings("rawtypes")
	private static void printSets()	{
		Set h1 = new HashSet<String>();
		h1.add("List");
		h1.add("Set");
		h1.add("Queue");
		h1.add("Map");
		System.out.println("HashSet Elements:");
		System.out.print("\t" + h1 + "\n");
		
		Set t1 = new TreeSet<String>();
		t1.add("List");
		t1.add("Set");
		t1.add("Queue");
		t1.add("Map");
		System.out.println("TreeSet Elements:");
		System.out.print("\t" + t1 + "\n");
	}
	
	/**
	 * 比较Map的put方法:注意元素的位置
	 */
	private static void printMaps()	{
		Map<String, String> h1 = new HashMap<String, String>();
		h1.put("List", "ArrayList");
		h1.put("Set", "HashSet");
		h1.put("Queue", "PriorityQueue");
		h1.put("Map", "HashMap");
		System.out.println("HashMap Elements:");
		System.out.print("\t" + h1 + "\n");
		
		Map<String, String> t1 = new TreeMap<String,String>();
		t1.put("List", "ArrayList");
		t1.put("Set", "HashSet");
		t1.put("Queue", "PriorityQueue");
		t1.put("Map", "HashMap");
		System.out.println("TreeMap Elements:");
		System.out.print("\t" + t1 + "\n");
		
	}
}
