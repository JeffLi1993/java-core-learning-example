package org.javacore.collection.map;

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
 *  * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-6-18 21:36:04
 * HashMap的Add方法
 */
public class HaspMapT{
	public static void main(String[] args)
	{
		objOper();
		nullOper();
	}
	
	/**
	 * HaspMap操作对象方法
	 */
	public static void objOper(){
		Map<String, Employee> employees = new HashMap<String, Employee>();
		
		String number = "1206010035";
		//设置对象
		employees.put(number, new Employee());
		System.out.println(employees);
		
		// 获取对象
		System.out.println(employees.get(number));
	}
	
	/**
	 * HaspMap的put方法
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void nullOper(){
		Map map = new HashMap<String, String>();
		map.put(null, "null01");
		map.put(null, "null02");
		System.out.println(map);
		System.out.println(map.get(null));
	}
}
class Employee
{}