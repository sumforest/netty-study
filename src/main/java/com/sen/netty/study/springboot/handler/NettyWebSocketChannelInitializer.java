package com.sen.netty.study.springboot.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author: Sen
 * @date 2020/5/26 0026 14:24
 * @description: 管道初始化器
 */
@Component
@Qualifier("somethingChannelInitializer")
public class NettyWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private TextWebSocketFrameHandler textWebSocketFrameHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 获取管道
        ChannelPipeline pipeline = ch.pipeline();
        // 设置管道的编码、解码器
        pipeline.addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(65536))
                .addLast(new ChunkedWriteHandler())
                // 设置websocket路径
                .addLast(new WebSocketServerProtocolHandler("/ws"))
                // 设置自定义拦截器
                .addLast(textWebSocketFrameHandler);
    }
}

