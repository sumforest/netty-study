package com.sen.netty.study.springboot.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @author: Sen
 * @date 2020/5/26 0026 11:12
 * @description: 启动Netty服务
 */
@Component
public class TCPServer {

    @Autowired
    private ServerBootstrap serverBootstrap;

    @Autowired
    private InetSocketAddress inetSocketAddress;

    private Channel serverChannel;

    public void start() throws InterruptedException {
        serverChannel = serverBootstrap.bind(inetSocketAddress).sync().channel().closeFuture().sync().channel();
    }

    /**
     * 销毁前进行资源释放操作
     */
    @PreDestroy
    public void stop(){
        // 关闭通道
        serverChannel.close();
        // 关闭父通道
        serverChannel.parent().close();
    }

    public ServerBootstrap getServerBootstrap() {
        return serverBootstrap;
    }

    public void setServerBootstrap(ServerBootstrap serverBootstrap) {
        this.serverBootstrap = serverBootstrap;
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public void setInetSocketAddress(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
    }
}
