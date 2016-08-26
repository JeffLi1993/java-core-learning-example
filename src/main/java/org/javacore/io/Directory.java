package org.javacore.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
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
 * @since 2015-7-13 09:17:11
 * 目录实用工具
 */
public final class Directory {
	
	public static File[] local(File dir,final String regex){
		return dir.listFiles(new FilenameFilter() { // 文件过滤接口
			private Pattern pattern = Pattern.compile(regex);
			
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String path, final String regex){
		return local(new File(path),regex);
	}

	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<>();
		public List<File> dirs = new ArrayList<>();
		
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		public void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		@Override
		public String toString() {
			return "dirs: " + dirs + 
					"\n\nfiles: " + files;
		}
	}	
	
	public static TreeInfo walk(String start,String regex) {
		return recuresDirs(new File(start),regex);
	}
	
	public static TreeInfo walk(File start,String regex) {
		return recuresDirs(start, regex);
	}
	
	public static TreeInfo walk(File start) {
		return recuresDirs(start, ".*");// 全部
	}
	
	public static TreeInfo walk(String start) {
		return recuresDirs(new File(start), ".*");// 全部
	}
	
	public static TreeInfo recuresDirs(File startDir,String regex) {
		TreeInfo result = new TreeInfo();
		for(File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recuresDirs(item, regex));
			} else
				if (item.getName().matches(regex))
					result.files.add(item);
		}
		return result;
	}
	
}
