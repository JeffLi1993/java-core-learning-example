//package org.javacore.io;
//
//import java.io.File;
//import java.io.FileDescriptor;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.channels.FileChannel;
//
//import sun.misc.IoTrace;
//import sun.nio.ch.FileChannelImpl;
//
///**
// * FileInputStream 从文件系统的文件中获取输入字节流。文件取决于主机系统。
// * 	比如读取图片等的原始字节流。如果读取字符流，考虑使用 FiLeReader。
// */
//public class SFileInputStream extends InputStream
//{
//    /* 文件描述符类---此处用于打开文件的句柄 */
//    private final FileDescriptor fd;
//
//    /* 引用文件的路径 */
//    private final String path;
//
//    /* 文件通道，NIO部分 */
//    private FileChannel channel = null;
//
//    private final Object closeLock = new Object();
//    private volatile boolean closed = false;
//
//    private static final ThreadLocal<Boolean> runningFinalize =
//        new ThreadLocal<>();
//
//    private static boolean isRunningFinalize() {
//        Boolean val;
//        if ((val = runningFinalize.get()) != null)
//            return val.booleanValue();
//        return false;
//    }
//
//    /* 通过文件路径名来创建FileInputStream */
//    public FileInputStream(String name) throws FileNotFoundException {
//        this(name != null ? new File(name) : null);
//    }
//
//    /* 通过文件来创建FileInputStream */
//    public FileInputStream(File file) throws FileNotFoundException {
//        String name = (file != null ? file.getPath() : null);
//        SecurityManager security = System.getSecurityManager();
//        if (security != null) {
//            security.checkRead(name);
//        }
//        if (name == null) {
//            throw new NullPointerException();
//        }
//        if (file.isInvalid()) {
//            throw new FileNotFoundException("Invalid file path");
//        }
//        fd = new FileDescriptor();
//        fd.incrementAndGetUseCount();
//        this.path = name;
//        open(name);
//    }
//
//    /* 通过文件描述符类来创建FileInputStream */
//    public FileInputStream(FileDescriptor fdObj) {
//        SecurityManager security = System.getSecurityManager();
//        if (fdObj == null) {
//            throw new NullPointerException();
//        }
//        if (security != null) {
//            security.checkRead(fdObj);
//        }
//        fd = fdObj;
//        path = null;
//        fd.incrementAndGetUseCount();
//    }
//
//    /* 打开文件，为了下一步读取文件内容。native方法 */
//    private native void open(String name) throws FileNotFoundException;
//
//    /* 从此输入流中读取一个数据字节 */
//    public int read() throws IOException {
//        Object traceContext = IoTrace.fileReadBegin(path);
//        int b = 0;
//        try {
//            b = read0();
//        } finally {
//            IoTrace.fileReadEnd(traceContext, b == -1 ? 0 : 1);
//        }
//        return b;
//    }
//
//    /* 从此输入流中读取一个数据字节。native方法 */
//    private native int read0() throws IOException;
//
//    /* 从此输入流中读取多个字节到byte数组中。native方法 */
//    private native int readBytes(byte b[], int off, int len) throws IOException;
//
//    /* 从此输入流中读取多个字节到byte数组中。 */
//    public int read(byte b[]) throws IOException {
//        Object traceContext = IoTrace.fileReadBegin(path);
//        int bytesRead = 0;
//        try {
//            bytesRead = readBytes(b, 0, b.length);
//        } finally {
//            IoTrace.fileReadEnd(traceContext, bytesRead == -1 ? 0 : bytesRead);
//        }
//        return bytesRead;
//    }
//    
//    /* 从此输入流中读取最多len个字节到byte数组中。 */
//    public int read(byte b[], int off, int len) throws IOException {
//        Object traceContext = IoTrace.fileReadBegin(path);
//        int bytesRead = 0;
//        try {
//            bytesRead = readBytes(b, off, len);
//        } finally {
//            IoTrace.fileReadEnd(traceContext, bytesRead == -1 ? 0 : bytesRead);
//        }
//        return bytesRead;
//    }
//
//    
//    public native long skip(long n) throws IOException;
//
//    /* 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数。 */
//    public native int available() throws IOException;
//
//    /* 关闭此文件输入流并释放与此流有关的所有系统资源。 */
//    public void close() throws IOException {
//        synchronized (closeLock) {
//            if (closed) {
//                return;
//            }
//            closed = true;
//        }
//        if (channel != null) {
//           fd.decrementAndGetUseCount();
//           channel.close();
//        }
//
//        int useCount = fd.decrementAndGetUseCount();
//
//        if ((useCount <= 0) || !isRunningFinalize()) {
//            close0();
//        }
//    }
//
//    public final FileDescriptor getFD() throws IOException {
//        if (fd != null) return fd;
//        throw new IOException();
//    }
//
//    /* 获取此文件输入流的唯一FileChannel对象 */
//    public FileChannel getChannel() {
//        synchronized (this) {
//            if (channel == null) {
//                channel = FileChannelImpl.open(fd, path, true, false, this);
//                fd.incrementAndGetUseCount();
//            }
//            return channel;
//        }
//    }
//
//    private static native void initIDs();
//
//    private native void close0() throws IOException;
//
//    static {
//        initIDs();
//    }
//
//    protected void finalize() throws IOException {
//        if ((fd != null) &&  (fd != FileDescriptor.in)) {
//            runningFinalize.set(Boolean.TRUE);
//            try {
//                close();
//            } finally {
//                runningFinalize.set(Boolean.FALSE);
//            }
//        }
//    }
//}