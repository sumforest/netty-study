package com.sen.netty.study.simple.im;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * @author: Sen
 * @date 2020/5/23 0023 16:44
 * @description: 启动客户端
 */
public class SimpleChatClient {

    private final int port;

    private final String host;

    public SimpleChatClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void run(){
        NioEventLoopGroup group = new NioEventLoopGroup();
        // 启动NIO的辅助基类
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SimpleChatClientInitializer());
        try {


            Channel channel = bootstrap.connect(new InetSocketAddress(host, port)).sync().channel();
            // 获取控制太输入
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 一行一行的写数据到服务端
            while (true) {
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
        } catch (Exception e) {
             e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient(8080, "127.0.0.1").run();
    }
}
