package org.javacore.io;

import java.io.IOException;

/**
 * 所有字节输入流实现类的基类
 */
public abstract class SInputStream {

	// 缓存区字节数组最大值
    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    // 从输入流中读取数据的下一个字节，以int返回
    public abstract int read() throws IOException;

    // 从输入流中读取数据的一定数量字节，并存储在缓存数组b
    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }

    // 从输入流中读取数据最多len个字节，并存储在缓存数组b
    public int read(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }

        int c = read();
        if (c == -1) {
            return -1;
        }
        b[off] = (byte)c;

        int i = 1;
        try {
            for (; i < len ; i++) {
                c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte)c;
            }
        } catch (IOException ee) {
        }
        return i;
    }

    // 跳过输入流中数据的n个字节
    public long skip(long n) throws IOException {

        long remaining = n;
        int nr;

        if (n <= 0) {
            return 0;
        }

        int size = (int)Math.min(MAX_SKIP_BUFFER_SIZE, remaining);
        byte[] skipBuffer = new byte[size];
        while (remaining > 0) {
            nr = read(skipBuffer, 0, (int)Math.min(size, remaining));
            if (nr < 0) {
                break;
            }
            remaining -= nr;
        }

        return n - remaining;
    }

    // 返回下一个方法调用能不受阻塞地从此读取（或者跳过）的估计字节数
    public int available() throws IOException {
        return 0;
    }

    // 关闭此输入流，并释放与其关联的所有资源
    public void close() throws IOException {}

    // 在此输出流中标记当前位置
    public synchronized void mark(int readlimit) {}

    // 将此流重新定位到最后一次对此输入流调用 mark 方法时的位置。
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    // 测试此输入流是否支持 mark 和 reset 方法
    public boolean markSupported() {
        return false;
    }

}
