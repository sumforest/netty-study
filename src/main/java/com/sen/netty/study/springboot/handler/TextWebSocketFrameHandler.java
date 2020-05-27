package com.sen.netty.study.springboot.handler;

import com.sen.netty.study.springboot.redis.RedisDao;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Sen
 * @date 2020/5/26 0026 14:28
 * @description: 自定义管道处理器
 */
@Component
@ChannelHandler.Sharable
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Resource
    private RedisDao redisDao;

    /**
     * 定义接收消息的操作
     *
     * @param ctx 通道处理器山下文
     * @param msg 消息
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        Channel incoming = ctx.channel();
        // 通过channelId获取用户名
        String userName = redisDao.getString(String.valueOf(incoming.id()));
        for (Channel channel : channels) {
            if (channel != incoming) {
                channel.writeAndFlush("[" + userName + "] :" + msg.text());
            } else {
                channel.writeAndFlush("[You] :" + msg.text());
            }
        }
    }

    /**
     * 定义用户新连接操作
     *
     * @param ctx 通道处理器山下文
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.printf("新加入用户IP：%s", incoming.remoteAddress());
        String userName = System.currentTimeMillis() + "用户";
        // 通知所有用户有新用户上线
        for (Channel channel : channels) {
            channel.writeAndFlush(userName + "，上线！");
        }
        // 保存用户通道
        channels.add(incoming);
        // 保存用户名到redis
        redisDao.saveString(String.valueOf(incoming.id()), userName);
    }

    /**
     * 定义用户离开操作
     *
     * @param ctx 通道处理器山下文
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        String userName = redisDao.getString(String.valueOf(incoming.id()));
        // 删除当前用户通道
        channels.remove(incoming);
        // 通知所有用户有用户离开
        for (Channel channel : channels) {
            channel.writeAndFlush(userName + "，离开！");
        }
        // 删除redis中的用户名
        redisDao.deleteString(String.valueOf(incoming.id()));
    }

    /**
     * 定义用户在线操作
     *
     * @param ctx 通道处理器山下文
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.println(redisDao.getString(String.valueOf(incoming.id())) + ",在线！");
    }

    /**
     * 定义用户离线操作
     *
     * @param ctx 通道处理器山下文
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.println(redisDao.getString(String.valueOf(incoming.id())) + ",掉线！");
    }

    /**
     * 定义用户异常操作
     *
     * @param ctx   通道处理器山下文
     * @param cause 所捕获的异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.printf("用户：%s异常", redisDao.getString(String.valueOf(incoming.id())));
        cause.printStackTrace();
        // 关闭通道处理器上下文
        ctx.close();
    }
}
