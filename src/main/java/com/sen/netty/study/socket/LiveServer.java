package com.sen.netty.study.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Sen
 * @date 2020/5/22 0022 20:03
 * @description: socket长连接服务器
 */
public class LiveServer {

    private static Logger log = LoggerFactory.getLogger(LiveServer.class);

    private int port;

    public LiveServer(int port) {
        this.port = port;
    }

    /**
     * 创建socket服务器
     *
     * @author: Sen
     * @date: 2020/5/22 0022 20:04
     * @param: []
     * @return: void
     */
    public void start() {
        // 创建启动服务器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 创建Nio事件组
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        // 把事件组添加到启动服务器中，并设置相关参数
        serverBootstrap.group(eventExecutors)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        log.debug("initChannel: {}", socketChannel);
                        // 设置ChannelHandler的容器PipeLine
                        socketChannel.pipeline();
//                                .addLast("decoder")
                    }
                })
                // 定义连接队列的大小
                .option(ChannelOption.SO_BACKLOG, 128)
                // 启动长连接
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

    }
}
