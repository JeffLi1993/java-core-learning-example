package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
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
 * @since 2015-6-18 21:05:38
 * 	ArrayList与LinkedList性能的对比
 */
public class PerBtwnArlAndLklT{
	
	public static void main(String[] args) {
		testPerBtwnArlAndLkl();
	}
	
	/**
	 * 	ArrayList与LinkedList各方法性能的对比
	 */
	public static void testPerBtwnArlAndLkl(){
		ArrayList<Integer> 	arrayList  = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
				
		// ArrayList add方法
		long startTime = System.nanoTime();
		long endTime;
		long duration; 
		for (int i = 0; i < 100000; i++)
			arrayList.add(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);
		 
		// LinkedList add方法
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++)
			linkedList.add(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);
		 
		// ArrayList get方法
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			arrayList.get(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration);
		 
		// LinkedList get方法
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			linkedList.get(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration);
		 
		// ArrayList remove方法
		startTime = System.nanoTime();
		for (int i = 9999; i >=0; i--)
			arrayList.remove(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration);
		 
		// LinkedList remove方法
		startTime = System.nanoTime();
		for (int i = 9999; i >=0; i--)
			linkedList.remove(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);
	}
}
