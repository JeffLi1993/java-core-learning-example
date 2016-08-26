package org.jee.rpc;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 描述:RPC服务发布者
 * Created by bysocket on 16/2/28.
 */
public class RpcExporter {
    // 创建线程池
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName,int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));
        try {
            while (true) {
                /**
                 * 监听Client的TCP连接,将其封装成Task,由线程池执行.
                 */
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        } finally {
          serverSocket.close();  
        }
    }

    /**
     * 线程Task:
     * 1. 将客户端发送的二进制流反序列化成对象,反射调用服务实现者,获取执行结果
     * 2. 将执行结果对象反序列化,通过Socket发送给客户端
     * 3. 远程服务调用完成之后,释放Socket等连接资源,防止句柄泄漏
     */
    private static class ExporterTask implements Runnable {
        Socket client = null;
        public ExporterTask(Socket accept) {
            this.client = accept;
        }

        @Override
        public void run() {
            ObjectInputStream   input  = null;
            ObjectOutputStream  output = null;
            try {
                // 对象输入流
                input = new ObjectInputStream(client.getInputStream());

                // 获取接口名
                String interfaceName = input.readUTF();
                // 获取方法名
                String methodName = input.readUTF();
                // 获取方法的参数数组
                Class<?>[] paramTypes = (Class<?>[]) input.readObject();
                // 获取传入参数对象数组
                Object[] arguments = (Object[]) input.readObject();

                // 获取服务对象类
                Class<?> service = Class.forName(interfaceName);
                // 获取服务方法
                Method method = service.getMethod(methodName,paramTypes);
                // 获取服务方法返回对象
                Object result = method.invoke(service.newInstance(),arguments);

                // 对象输出流
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭流的操作
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
