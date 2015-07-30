# java-core-learning-example
关于Java核心技术学习积累的例子，是初学者及核心技术巩固的最佳实践。

## 作者与学习乐园
源码地址:我的[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>
作者： [李强强](http://www.bysocket.com/ "李强强")<br>
QQ群：编程之美 365234583 [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美")

## 项目结构
- src 目录<br>
Java核心技术学习代码兼测试案例<br>
- test目录(测试包名与src目录保持一致)<br>
对应学习代码包的详细测试案例<br>

包目录：

	├── org.javacore.collection	// Java集合
	├── org.javacore.collection.list	// Java集合List
	├── org.javacore.collection.map	// Java集合Map
	├── org.javacore.collection.queue	// Java集合Queue
	├── org.javacore.collection.set	// Java集合Set
	├── org.javacore.collection.util	// Java集合工具类
	├── org.javacore.io			// Java IO
	├── org.javacore.io.byteoper		// Java IO 字节操作
	├── org.javacore.nio			// Java NIO
	├── org.javacore.thread		// Java 线程
	│
	拼命更新！顶！d=====(￣▽￣*)b

详细目录：

	├── README.md						// 项目唯一详细文档
	├── org.javacore.collection		// Java集合
	├── 	PerBtwnAllCollectionsT.java		// 各集合添加方法性能对比
	├── org.javacore.collection.list		// Java集合List
	├── 	ArrayListT.java					// ArrayList的使用
	├── 	PerBtwnArlAndLklT.java			// ArrayList与LinkedList性能的对比
	├── org.javacore.collection.map		// Java集合Map
	├── 	HashMapObjT.java				// HashMap操作对象的决定因子：hashCode与equals
	├── 	HaspMapT.java					// HashMap的Add方法
	├── 	TreeMapT.java					// TreeMap的使用
	├── org.javacore.collection.queue		// Java集合Queue
	├── 	PriorityQueueT.java				// PriorityQueue的使用
	├── org.javacore.collection.set		// Java集合Set
	├── 	HashSetObjT.java				// HashSet操作对象的决定因子：hashCode与equals
	├── 	HashSetsCopyT.java				// HashSet及其子类的转换使用
	├── 	HashSetT.java					// HashSet的Add方法
	├── 	SetContainT.java				// Set的Contains方法
	├── 	TreeSetT.java					// TreeSet操作实现Comparable接口的对象
	├── org.javacore.collection.util		// Java集合工具类
	├── 	CollectionsT.java				// Collections的使用	
	├── 	IterAndListIterT.java			// Iterator与ListIterator的区别
	├── 	PerBtwnEmptyMapAndHashMapT.java	// Collections.EMPTY_MAP 与 new HashMap 性能对比
	├── org.javacore.io				// Java IO
	├── 	BufferedInputFileT.java			// 缓冲输入文件
	├── 	Directory.java					// 目录实用工具
	├── 	DirListT.java					// 列出目录并排序
	├── 	FileMethodsT.java				// File方法详细使用
	├── 	FilenameFilterT.java			// 类名过滤器的使用
	├── 	FileT.java						// File类的使用
	├── 	FormatteMemoryInput.java		// 格式化内存输入
	├── 	JavaFileListT.java				// FilenameFilter文件过滤器的使用
	├── 	MemoryInputT.java				// 内存中输入
	├── 	PipeStreamT.java				// 管道输入输出流的的使用
	├── 	RandomAccessFileT.java			// RandomAccessFile的使用
	├── org.javacore.io.byteoper		// Java IO 字节操作
	├── 	IntegerConvertT.java			// Integer与byte数组转换
	├── 	IntegerOperT.java				// Integer类的进制转换
	├── 	LongConvertT.java				// Long与byte数组转换
	├── 	StringConvertT.java				// String转换成byte数组
	├── org.javacore.nio				// Java NIO
	├── 	FileChannelT.java				// FileChannel读写文件案例
	├── org.javacore.thread			// Java 线程
	├── 	MyThread.java					// Thread的简单使用
	├── 	MyRunnable.java					// Runnable接口的简单使用
	拼命更新！顶！d=====(￣▽￣*)b

##学习方法
根据包目录，进行一块一块学习。然后针对某类，请看下相对应的test包或者src下直接测试案例，进行学习。
