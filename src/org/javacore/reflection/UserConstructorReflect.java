package org.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
 * @since 2015-9-8 09:35:35
 * 利用反射通过构造器创建一个实例
 */
public class UserConstructorReflect {
	public static void main(String[] args) throws NoSuchMethodException,
		SecurityException, InstantiationException,
		IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException {
		// 获取User类型
		Class<?> userClass = User.class;
		// 获取默认构造器
		Constructor<?> constructor = userClass.getConstructor();
		// 获取带int参数的构造器
		Constructor<?> intConstructor = userClass.getConstructor(int.class);
		// 获取带int和String参数的构造器
		Constructor<?> bothConstructor = userClass.getConstructor(int.class,String.class);
		
		// 使用反射，获取新的User对象
		User u1 = (User) constructor.newInstance();
		User u2 = (User) intConstructor.newInstance(1);
		User u3 = (User) bothConstructor.newInstance(2,"BYSocket");
		
		System.out.println(u1.toString());
		System.out.println(u2.toString());
		System.out.println(u3.toString());
	}
}
