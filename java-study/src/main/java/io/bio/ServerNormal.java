package io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述: <br>
 * BIO服务端源码
 * @Date 2019/8/16 21:13
 * @Author lds
 */
public class ServerNormal {
    //默认端口号
    private static int DEFAULT_PORT = 123456;
    //单例的ServerSocket
    private static ServerSocket server;

    //根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
    public static void start() throws IOException {
        //使用默认值
        start(DEFAULT_PORT);
    }

    //这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
    public synchronized static void start(int port) throws IOException {
        //启动过服务端了就直接返回，不需要再启动了
        if (server != null) return;
        //通过构造函数创建ServerSocket
        //如果端口合法且空闲，服务端就监听成功
        server = new ServerSocket(port);
        System.out.println("服务器已启动，端口号：" + port);
        //通过无线循环监听客户端连接
        //如果没有客户端接入，将阻塞在accept操作上。
        try {
            while (true) {
                Socket socket = server.accept();
                //当有新的客户端接入时，会执行下面的代码
                //然后创建一个新的线程处理这条Socket链路
                new Thread(new ServerHandle(socket)).start();

            }
        } finally {
            //一些必要的清理工作
            if (server != null) {
                System.out.println("服务器已关闭。");
                server.close();
                server = null;
        }
        }
    }
}