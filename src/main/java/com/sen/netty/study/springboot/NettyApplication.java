package com.sen.netty.study.springboot;

import com.sen.netty.study.springboot.config.TCPServer;
import com.sen.netty.study.springboot.handler.NettyWebSocketChannelInitializer;
import com.sen.netty.study.springboot.handler.TextWebSocketFrameHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Sen
 * @date 2020/5/26 0026 9:57
 * @description: Netty SpringBoot整合启动类
 */
@SpringBootApplication
public class NettyApplication {

    /**
     * netty的tcp端口
     */
    @Value("${netty.tcp.port}")
    private int tcpPort;

    /**
     * boss组工作线程数
     */
    @Value("${netty.boss.thread.count}")
    private int bossThreadCount;

    /**
     * worker组工作线程数
     */
    @Value("${netty.worker.thread.count}")
    private int workerThreadCount;

    /**
     * 是否开启长连接
     */
    @Value("${netty.so.keepalive}")
    private boolean soKeepalive;

    @Value("${netty.so.backlog}")
    private int soBacklog;

    /**
     * 初始化boss事件组
     *
     * @return boss工作组
     */
    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(bossThreadCount);
    }

    /**
     * 初始化worker事件组
     *
     * @return worker事件组
     */
    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(workerThreadCount);
    }

    @Autowired
    @Qualifier("somethingChannelInitializer")
    private NettyWebSocketChannelInitializer nettyWebSocketChannelInitializer;

    @Bean
    public Map<ChannelOption<?>, Object> tcpOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<>();
        options.put(ChannelOption.SO_KEEPALIVE, soKeepalive);
        options.put(ChannelOption.SO_BACKLOG, soBacklog);
        return options;
    }

    @Bean
    public ServerBootstrap ServerBootstrap() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup())
                .group(workerGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(nettyWebSocketChannelInitializer);
        // 设置options
        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpOptions();
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
        for (ChannelOption channelOption : keySet) {
            serverBootstrap.option(channelOption, tcpChannelOptions.get(channelOption));
        }
        return serverBootstrap;
    }

    @Bean
    public InetSocketAddress inetSocketAddress() {
        return new InetSocketAddress(tcpPort);
    }

    public static void main(String[] args) throws InterruptedException {
        // 获取应用可配置上下文
        ConfigurableApplicationContext context = SpringApplication.run(NettyApplication.class, args);
        // 获取tcpServer实例对象
        TCPServer tcpServer = context.getBean(TCPServer.class);
        // 启动TCPServer
        tcpServer.start();
    }
}
