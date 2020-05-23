package com.sen.netty.study.simple.im;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Sen
 * @date 2020/5/23 0023 15:30
 * @description: 服务端处理IO
 * 比较常规运行顺序是：
 * 1.handlerAdded()
 * 2.channelActive()
 * 3.channelRead0()
 * 4.channelInactive()
 * 5.handlerRemoved()
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 用于保存连接的channel
     */
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static final Logger log = LoggerFactory.getLogger(SimpleChatServerHandler.class);

    /**
     * 每当服务端接口到新的客户端连接时，获取其channel并且通知所有已连接的客户端的channel
     *
     * @author: Sen
     * @date: 2020/5/23 0023 15:42
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 新连接客户端的channel
        Channel incoming = ctx.channel();
        // 通知所有已经连接的客户端，有一个新连接加入
        for (Channel channel : channels) {
            channel.writeAndFlush("[SERVER]-" + incoming.remoteAddress() + "加入\n");
        }
        // 把新连接的channel加入group
        channels.add(incoming);
    }

    /**
     * 服务端监听到客户端活动
     *
     * @author: Sen
     * @date: 2020/5/23 0023 15:44
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 服务端接收到客户端上线
        Channel incoming = ctx.channel();
        log.error("SimpleChatClient: " + incoming + "上线");
    }

    /**
     * 每当服务端接收到客户端的消息消息时转发到所有的channel
     *
     * @author: Sen
     * @date: 2020/5/23 0023 15:48
     * @param: [ctx, msg]
     * @return: void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        // 将服务端接收的转发给所有channel
        for (Channel channel : channels) {
            // 消息的接收channel不是自己
            if (channel != incoming) {
                channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + msg + "\n");
            } else {
                channel.writeAndFlush("[You]" + msg + "\n");
            }
        }
    }

    /**
     * 当服务端监听到客户端不活动
     *
     * @author: Sen
     * @date: 2020/5/23 0023 15:54
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        log.error("SimpleChatClient: {},掉线", incoming.remoteAddress());
    }

    /**
     * 当服务端断开与客户端的连接时从ChannelGroup删除该连接的channel，并通知所有连接客户端的channel
     *
     * @author: Sen
     * @date: 2020/5/23 0023 15:56
     * @param: [ctx]
     * @return: void
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        // 移除断开客户端的channel
        channels.remove(incoming);
        // 通知所有连接的客户端
        for (Channel channel : channels) {
            channel.writeAndFlush("[SERVER]" + channel.remoteAddress() + "离开\n");
        }
    }

    /**
     * 异常处理
     *
     * @author: Sen
     * @date: 2020/5/23 0023 15:47
     * @param: [ctx, cause]
     * @return: void
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("exceptionCaught");
        if (cause != null) {
            cause.printStackTrace();
        }
        if (ctx != null) {
            ctx.close();
        }
    }
}
