package com.netty.simplesocket;

import java.io.*;
import java.net.Socket;

public class ClientSocketDemo {

    public static void main(String[] args) {
        try {
            //创建Socket对象
            Socket socket=new Socket("localhost",8888);

            //根据输入输出流和服务端连接
            //获取一个输出流，向服务端发送信息
            OutputStream outputStream=socket.getOutputStream();
            //将输出流包装成打印流
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.print("服务端你好，我是Balla_兔子");
            printWriter.flush();
            //关闭输出流
            socket.shutdownOutput();
            //获取一个输入流，接收服务端的信息
            InputStream inputStream=socket.getInputStream();
            //包装成字符流，提高效率
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            //缓冲区
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String info="";
            //临时变量
            String temp=null;
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("客户端接收服务端发送信息："+info);
            }

            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
