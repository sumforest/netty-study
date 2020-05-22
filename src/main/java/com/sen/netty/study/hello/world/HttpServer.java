package com.sen.netty.study.hello.world;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

/**
 * @author: Sen
 * @date 2020/5/22 14:13
 * @description: Netty服务器
 */
public class HttpServer {

    private final int port;


    public HttpServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 创建服务启动
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 创建事件组
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        // 添加组到启动类
        serverBootstrap.group(eventExecutors)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        System.out.println("InitializeChanel: " + socketChannel);
                        socketChannel.pipeline()
                                .addLast("decoder", new HttpRequestDecoder())
                                .addLast("encoder", new HttpResponseDecoder())
                                .addLast("aggregator", new HttpObjectAggregator(5 * 1024))
                                // 添加自定义处理逻辑
                                .addLast("handler", new HttpHandler());
                    }
                });
        // 绑定端口,同步
        serverBootstrap.bind(this.port).sync();
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动服务器
        new HttpServer(8080).start();
        System.out.println("The server has been start!");
    }
}
