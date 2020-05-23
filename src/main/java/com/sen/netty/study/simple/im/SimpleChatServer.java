package com.sen.netty.study.simple.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Sen
 * @date 2020/5/23 0023 16:12
 * @description: 服务器
 */
public class SimpleChatServer {

    private static final Logger log = LoggerFactory.getLogger(SimpleChatServerHandler.class);

    private final int port;

    public SimpleChatServer(int port) {
        this.port = port;
    }

    /**
     * 启动逻辑
     *
     * @author: Sen
     * @date: 2020/5/23 0023 16:13
     * @param: []
     * @return: void
     */
    public void run(){
        // NioEventLoopGroup 是用来处理IO操作的多线程事件循环器
        // 用来接收进来的连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 用来处理已经被接收的连接
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        // 创建启动NIO服务的辅助启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 为bootstrap设置acceptor的EventLoopGroup和client的EventLoopGroup
        // 这些EventLoopGroups用于处理所有的IO事件
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChatServerInitializer())
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE,true);

        ChannelFuture future;
        try {
            log.error("服务器启动了。。。");
            // 绑定端口
             future = serverBootstrap.bind(this.port).sync();
            // 等待服务器关闭,本小程序不会发生，这时可以关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            log.error("SimpleChatServer关闭了");
        }
    }

    public static void main(String[] args) {
        new SimpleChatServer(8080).run();
    }
}
