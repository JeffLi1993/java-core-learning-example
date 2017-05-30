# java-core-learning-example
关于Java核心技术学习积累的例子，是初学者及核心技术巩固的最佳实践。

## Spring For All 社区
Spring For All 社区是新组建的关于 Spring 的纯技术交流社区（涵盖 Spring Boot、Spring Cloud 等内容），集诸多开源爱好者和技术大牛贡献内容和交流问题。我们不夸大、不装逼、做最纯粹的技术分享！！！

看看我们超强的群众基础，欢迎有兴趣的朋友加入QQ群分享与交流：

①群： 365234583（满）<br>
②群： 123013854（满）<br>
③群： 290714704<br>
④群： 112133511<br>
⑤群： 157525002（满）<br>
⑥群： 564840207<br>
⑦群： 470962790（满）<br>
⑧群： 613456104（满）<br>
⑨群： 534583667<br>
⑩群： 210742970（满）

## 作者与学习乐园
源码地址:我的[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>
作者： [李强强](http://www.bysocket.com/ "李强强")<br>
QQ群：编程之美 365234583  [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美")<br>
编程之美② 290714704  <br><br>
关注微信公众号【泥瓦匠BYSokcet】，及时得到技术文章推送<br>
![公众号](https://github.com/JeffLi1993/springboot-learning-example/blob/master/doc/qrcode.jpg)


## 项目结构
- src 目录<br>
Java核心技术学习代码兼测试案例<br>
- test目录(测试包名与src目录保持一致)<br>
对应学习代码包的详细测试案例<br>

包目录：

	├── org.rpc		// 基于Java动态代理&Socket的简单RPC实现
	=================华丽的分割线=================
	├── org.javacore.base		// Java基础必备
	├── org.javacore.collection	// Java集合
	├── org.javacore.collection.list	// Java集合List
	├── org.javacore.collection.map	// Java集合Map
	├── org.javacore.collection.queue	// Java集合Queue
	├── org.javacore.collection.set	// Java集合Set
	├── org.javacore.collection.util	// Java集合工具类
	├── org.javacore.initAndCleanup	// Java初始化及清理
	├── org.javacore.io			// Java IO
	├── org.javacore.io.byteoper		// Java IO 字节操作
	├── org.javacore.io.zip			// Java IO ZIP压缩解压
	├── org.javacore.nio			// Java NIO
	├── org.javacore.reflection	// Java 反射
	├── org.javacore.rtti			// Java RTTI
	├── org.javacore.thread		// Java 线程
    =================实战JAVA 8=================
    ├── org.javacore.lambda		// lambda表达式
    ├── org.javacore.stream		// Stream API 集合的流式操作
	│
	拼命更新！顶！d=====(￣▽￣*)b

详细目录：

	├── README.md						// 项目唯一详细文档
	├── org.javacore.base			// Java基础必备
	├── 	CopyT.java						// 深拷贝与浅拷贝
	├── org.javacore.base.inter		// Java接口
	├── 	ApplyClass.java					// 不使用接口的接口案例
	├── 	ApplyInter.java					// 使用接口的接口案例
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
	├── org.javacore.initAndCleanup	// Java初始化及清理
	├── 	SimpleConstructor.java			// 简单构造器的展示
	├── 	SimpleConstructor2.java			// 带参数简单构造器的展示
	├── 	VoidConstructor.java			// 默认构造函数和方法的区别
	├── org.javacore.io				// Java IO
	├── 	BufferedInputFileT.java			// 缓冲输入文件
	├── 	CopyFileT.java					// 文件复制
	├── 	Directory.java					// 目录实用工具
	├── 	DirListT.java					// 列出目录并排序
	├── 	FileIOStreamT.java				// FileInputStream&FileOutputStream使用案例
	├── 	FileMethodsT.java				// File方法详细使用
	├── 	FilenameFilterT.java			// 类名过滤器的使用
	├── 	FileT.java						// File类的使用
	├── 	FormatteMemoryInput.java		// 格式化内存输入
	├── 	JavaFileListT.java				// FilenameFilter文件过滤器的使用
	├── 	MemoryInputT.java				// 内存中输入
	├── 	PipeStreamT.java				// 管道输入输出流的的使用
	├── 	RandomAccessFileT.java			// RandomAccessFile的使用
	├── 	StoringAndRecoveringData.java	// DataOutputStream和DataInputStream的使用案例
	├── 	SystemStreamT.java				// System.out, System.err中IO的使用
	├── 	UsingRandomAccessFile.java		// RandomAccessFile的使用案例
	├── org.javacore.io.byteoper		// Java IO 字节操作
	├── 	IntegerConvertT.java			// Integer与byte数组转换
	├── 	IntegerOperT.java				// Integer类的进制转换
	├── 	LongConvertT.java				// Long与byte数组转换
	├── 	StringConvertT.java				// String转换成byte数组
	├── org.javacore.io.zip				// Java IO ZIP压缩解压
	├── 	GZIPcompress.java				// GZIP简单使用
	├── 	ZipCompress.java				// 利用Zip进行多文件保存
	├── org.javacore.nio				// Java NIO
	├── 	AvailableCharSets.java		 	// 可用的CharSet打印
	├── 	BufferToText.java				// ByteBuffer与char之间转换的案例
	├── 	ChannelCopy.java				// FileChannel的文件复制案例
	├── 	Endians.java					// ByteBuffer中字节存储次序
	├── 	FileChannelT.java				// FileChannel读写文件案例
	├── 	FileChannelTransferTo.java		// FileChannel的transferTo/transferFrom案例
	├── 	FileLocking.java				// 文件加锁
	├── 	GetChannel.java					// 从流中获取FileChannel的案例
	├── 	GetData.java					// ByteBuffer操作类型数据的案例
	├── 	IntBufferDemo.java				// 通过IntBuffer操作ByteBuffer的int型数据
	├── 	LargeMappedFiles.java			// 内存映射文件的使用
	├── 	MappedIO.java					// MappedByteBuffer与Old IO的性能比
	├── 	UsingBuffers.java				// 利用buffer实现交换相邻字符
	├── 	ViewBuffers.java				// 不同视图下的缓冲区
	├── org.javacore.reflection		// Java 反射
	├── 	ArrayCopy.java					// 反射扩容对象数组
	├── 	EmployeeClass.java				// 反射在继承中的案例
	├── 	ObjectAnalyzer.java				// 反射对象分析工具
	├── 	ReflectionTest.java				// 反射对象构造函数、方法及字段
	├── 	User.java						// 反射构造器使用的bean
	├── 	UserConstructorReflect.java		// 利用反射通过构造器创建一个实例
	├── org.javacore.rtti				// Java RTTI
	├── 	ClassInitialization.java		// Class初始化案例
	├── 	ShowMethods.java				// 获取Class方法案例
	├── org.javacore.thread			// Java 线程
	├── 	BasicThreads.java				// 线程简单使用
	├── 	CachedThreadPool.java			// 线程池CachedThreadPool的简单使用
	├── 	CallableDemo.java				// Callable接口的使用 --- 实现带返回值的任务
 	├── 	DaemonFromFactory.java			// 后台线程工厂类的使用
 	├── 	DaemonThreadFactory.java		// 线程工厂类
 	├── 	DaemonsDontRunFinally.java		// 后台线程遇到Finally
	├── 	FixedThreadPool.java			// 线程池FixedThreadPool的简单使用
	├── 	LiftOff.java					// Runnable接口的实现类LiftOff
	├── 	MoreBasicThreads.java			// 线程简单使用-启动多个线程
	├── 	MyRunnable.java					// Runnable接口的简单使用
	├── 	MyThread.java					// Thread的简单使用
	├── 	SimpleDaemons.java				// Daemon后台线程的简单使用
   	├── 	SimplePriorities.java			// 线程优先级的使用
	├── 	SingleThreadExecutor.java		// SingleThreadExecutor的使用
	├── 	SleepingTask.java			    // 休眠线程sleep的使用
	拼命更新！顶！d=====(￣▽￣*)b
 
## 学习方法
根据包目录，进行一块一块学习。然后针对某类，请看下相对应的test包或者src下直接测试案例，进行学习。
