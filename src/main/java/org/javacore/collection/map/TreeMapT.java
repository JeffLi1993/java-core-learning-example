package org.javacore.collection.map;

import java.util.Map;
import java.util.TreeMap;
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
 * 	TreeMap 的使用
 */
public class TreeMapT
{	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{
		Map map = new TreeMap();
		map.put("1", "1");
		map.put("4", "4");
		map.put("2", "2");
		map.put("2", "3");
		// 注意排序
		System.out.println(map);
	}
}