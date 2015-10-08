//package org.javacore.io;
//
//import java.io.File;
//import java.io.FileDescriptor;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.nio.channels.FileChannel;
//
//import sun.misc.IoTrace;
//import sun.nio.ch.FileChannelImpl;
//
///**
// * 文件输入流是用于将数据写入文件或者文件描述符类
// * 	比如写入图片等的原始字节流。如果写入字符流，考虑使用 FiLeWriter。
// */
//public class SFileOutputStream extends OutputStream
//{
//    /* 文件描述符类---此处用于打开文件的句柄 */
//    private final FileDescriptor fd;
//
//    /* 引用文件的路径 */
//    private final String path;
//
//    /* 如果为 true，则将字节写入文件末尾处，而不是写入文件开始处 */
//    private final boolean append;
//
//    /* 关联的FileChannel类，懒加载 */
//    private FileChannel channel;
//
//    private final Object closeLock = new Object();
//    private volatile boolean closed = false;
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
//    /* 通过文件名创建文件输入流 */
//    public FileOutputStream(String name) throws FileNotFoundException {
//        this(name != null ? new File(name) : null, false);
//    }
//
//    /* 通过文件名创建文件输入流，并确定文件写入起始处模式 */
//    public FileOutputStream(String name, boolean append)
//        throws FileNotFoundException
//    {
//        this(name != null ? new File(name) : null, append);
//    }
//
//    /* 通过文件创建文件输入流，默认写入文件的开始处 */
//    public FileOutputStream(File file) throws FileNotFoundException {
//        this(file, false);
//    }
//
//    /* 通过文件创建文件输入流，并确定文件写入起始处  */
//    public FileOutputStream(File file, boolean append)
//        throws FileNotFoundException
//    {
//        String name = (file != null ? file.getPath() : null);
//        SecurityManager security = System.getSecurityManager();
//        if (security != null) {
//            security.checkWrite(name);
//        }
//        if (name == null) {
//            throw new NullPointerException();
//        }
//        if (file.isInvalid()) {
//            throw new FileNotFoundException("Invalid file path");
//        }
//        this.fd = new FileDescriptor();
//        this.append = append;
//        this.path = name;
//        fd.incrementAndGetUseCount();
//        open(name, append);
//    }
//
//    /* 通过文件描述符类创建文件输入流 */
//    public FileOutputStream(FileDescriptor fdObj) {
//        SecurityManager security = System.getSecurityManager();
//        if (fdObj == null) {
//            throw new NullPointerException();
//        }
//        if (security != null) {
//            security.checkWrite(fdObj);
//        }
//        this.fd = fdObj;
//        this.path = null;
//        this.append = false;
//
//        fd.incrementAndGetUseCount();
//    }
//
//    /* 打开文件，并确定文件写入起始处模式 */
//    private native void open(String name, boolean append)
//        throws FileNotFoundException;
//
//    /* 将指定的字节b写入到该文件输入流，并指定文件写入起始处模式 */
//    private native void write(int b, boolean append) throws IOException;
//
//    /* 将指定的字节b写入到该文件输入流 */
//    public void write(int b) throws IOException {
//        Object traceContext = IoTrace.fileWriteBegin(path);
//        int bytesWritten = 0;
//        try {
//            write(b, append);
//            bytesWritten = 1;
//        } finally {
//            IoTrace.fileWriteEnd(traceContext, bytesWritten);
//        }
//    }
//
//    /* 将指定的字节数组写入该文件输入流，并指定文件写入起始处模式 */
//    private native void writeBytes(byte b[], int off, int len, boolean append)
//        throws IOException;
//
//    /* 将指定的字节数组b写入该文件输入流 */
//    public void write(byte b[]) throws IOException {
//        Object traceContext = IoTrace.fileWriteBegin(path);
//        int bytesWritten = 0;
//        try {
//            writeBytes(b, 0, b.length, append);
//            bytesWritten = b.length;
//        } finally {
//            IoTrace.fileWriteEnd(traceContext, bytesWritten);
//        }
//    }
//
//    /* 将指定len长度的字节数组b写入该文件输入流 */
//    public void write(byte b[], int off, int len) throws IOException {
//        Object traceContext = IoTrace.fileWriteBegin(path);
//        int bytesWritten = 0;
//        try {
//            writeBytes(b, off, len, append);
//            bytesWritten = len;
//        } finally {
//            IoTrace.fileWriteEnd(traceContext, bytesWritten);
//        }
//    }
//
//    /* 关闭此文件输出流并释放与此流有关的所有系统资源 */
//    public void close() throws IOException {
//        synchronized (closeLock) {
//            if (closed) {
//                return;
//            }
//            closed = true;
//        }
//
//        if (channel != null) {
//            fd.decrementAndGetUseCount();
//            channel.close();
//        }
//
//        int useCount = fd.decrementAndGetUseCount();
//
//        if ((useCount <= 0) || !isRunningFinalize()) {
//            close0();
//        }
//    }
//
//     public final FileDescriptor getFD()  throws IOException {
//        if (fd != null) return fd;
//        throw new IOException();
//     }
//
//    public FileChannel getChannel() {
//        synchronized (this) {
//            if (channel == null) {
//                channel = FileChannelImpl.open(fd, path, false, true, append, this);
//
//                fd.incrementAndGetUseCount();
//            }
//            return channel;
//        }
//    }
//
//    protected void finalize() throws IOException {
//        if (fd != null) {
//            if (fd == FileDescriptor.out || fd == FileDescriptor.err) {
//                flush();
//            } else {
//
//                runningFinalize.set(Boolean.TRUE);
//                try {
//                    close();
//                } finally {
//                    runningFinalize.set(Boolean.FALSE);
//                }
//            }
//        }
//    }
//
//    private native void close0() throws IOException;
//
//    private static native void initIDs();
//
//    static {
//        initIDs();
//    }
//
//}