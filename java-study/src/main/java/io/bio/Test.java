package io.bio;

import java.io.IOException;
import java.util.Random;

/**
 * 功能描述: <br>
 *  BIO也就是客户端一直在等待服务端的应答
 *  BIO主要的问题在于每当有一个新的客户端请求接入时，服务端必须创建一个新的线程来处理这条链路，
 *  在需要满足高性能、高并发的场景是没法应用的（大量创建新的线程会严重影响服务器性能，甚至罢工）
 * @Date 2019/8/16 22:32
 * @Author lds
 */
public class Test {
    //测试主方法
    public static void main(String[] args) throws Exception {
        //运行服务器
        new Thread(() -> {
            try {
                ServerBetter.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        System.out.println("prepare start client \n");
        //运行客户端
        final char operators[] = {'+', '-', '*', '/'};
        final Random random = new Random(System.currentTimeMillis());
        new Thread(() -> {
            while (true) {
                //随机产生算术表达式
                String expression = random.nextInt(10) + "" + operators[random.nextInt(4)] + (random.nextInt(10) + 1);
                Client.send(expression);
                try {
                    Thread.currentThread().sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}



