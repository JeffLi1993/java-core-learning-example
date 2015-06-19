package org.javacore.collection.set;

import java.util.HashSet;
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
 * @since 2015-6-19 15:41:03
 * 	HashSet 操作对象的决定因子：hashCode与equals
 */
public class HashSetObjT{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		HashSet objs = new HashSet();
		objs.add(new A());
		objs.add(new B());
		objs.add(new C());
		objs.add(new A());
		objs.add(new B());
		objs.add(new C());
		System.out.println("HashSet Elements:");
		System.out.print("\t" + objs + "\n");
	}
}
class A {
	public boolean equals(Object obj){
		return true;
	}
}

class B {
	public int hashCode(){
		return 1;
	}
}

class C {
	public int hashCode(){
		return 2;
	}

	public boolean equals(Object obj){
		return true;
	}
}