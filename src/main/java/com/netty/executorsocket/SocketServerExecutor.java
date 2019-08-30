package com.netty.executorsocket;

import com.netty.mutisocket.SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ObjectOutputStream
 *  OutputStream outputStream = socket.getOutputStream();
 *  ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
 *  User user=new User("admin","123456");
 *  objectOutputStream.writeObject(user);
 */
public class SocketServerExecutor {

    /**
     * Socket服务端
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端已启动，等待客户端连接..");

            while (true) {
                Socket socket = serverSocket.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
                SocketExecotePool socketExecotePool=new SocketExecotePool(50,1000);
                socketExecotePool.execute(new SocketThread(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
