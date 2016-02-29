package org.jee.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 描述:Rpc本地服务代理类
 * 1. 将本地接口调用转化为JDK的动态调用,在动态调用中实现接口的远程调用
 * 2. 创建Socket客户端,根据制定地址连接远程服务提供者
 * 3. 将远程服务调用所需的接口类,方法名,参数列表等编码后发送给服务提供者
 * 4. 同步阻塞等待服务端返回应答,获取应答后返回
 * Created by bysocket on 16/2/29.
 */
public class RpcImporter<S> {
    public S importer(final Class<?> serviceClass, final InetSocketAddress address) {
        // JDK动态代理,实现接口的远程调用
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass.getInterfaces()[0]},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectOutputStream output = null;
                        ObjectInputStream  input  = null;

                        try {
                            // 连接远程服务提供者
                            socket = new Socket();
                            socket.connect(address);

                            // 对象输出流
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);

                            input = new ObjectInputStream(socket.getInputStream());
                            return input.readObject();
                        } finally {
                            if (socket != null) {
                                socket.close();
                            }
                            if (output != null) {
                                output.close();
                            }
                            if (input != null) {
                                input.close();
                            }
                        }
                    }
                });
    }
}
