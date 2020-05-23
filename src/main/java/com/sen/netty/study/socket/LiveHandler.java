package com.sen.netty.study.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.ScheduledFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: Sen
 * @date 2020/5/23 0023 9:54
 * @description: 自定义处理逻辑
 */
public class LiveHandler extends SimpleChannelInboundHandler<LiveMessage> {

    private Logger log = LoggerFactory.getLogger(LiveHandler.class);

    /**
     * 存储channel和定时任务
     */
    private static Map<Integer, LiveChannelCache> map = new HashMap<>();

    /**
     * 处理channel逻辑
     *
     * @author: Sen
     * @date: 2020/5/23 0023 14:13
     * @param: [ctx, msg]
     * @return: void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LiveMessage msg) throws Exception {
        // 获取channel
        Channel channel = ctx.channel();
        // 获取channel的hashCode
        final int hashCode = channel.hashCode();
        // 当前channel不在map中说明还么被初始化，初始化
        if (!map.containsKey(hashCode)) {
            log.debug("----channel hashCode: {}", hashCode);
            // 设置channel关闭事件
            channel.closeFuture().addListener(future -> {
                log.debug("----channel will be closed，remove key：{}", hashCode);
                map.remove(hashCode);
            });
            ScheduledFuture scheduledFuture = ctx.executor().schedule(() -> {
                log.debug("----schedule runs,close channel: " + hashCode);
                channel.close();
            }, 10, TimeUnit.SECONDS);
            // 存入map中
            map.put(hashCode, new LiveChannelCache(channel, scheduledFuture));
        }

        switch (msg.getType()) {
            // 消息类型是心跳类型
            case LiveMessage.TYPE_HEART:
                LiveChannelCache liveChannelCache = map.get(hashCode);
                ScheduledFuture scheduledFuture = ctx.executor().schedule(() -> {
                    channel.close();
                }, 5, TimeUnit.SECONDS);
                liveChannelCache.getScheduledFuture().cancel(true);
                liveChannelCache.setScheduledFuture(scheduledFuture);
                ctx.writeAndFlush(msg);
                break;
            // 消息类型是消息类型
            case LiveMessage.TYPE_MESSAGE:
                map.entrySet().stream().forEach(entry -> {
                    Channel otherChannel = entry.getValue().getChannel();
                    otherChannel.writeAndFlush(msg);
                });
                break;
            default:
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.debug("----channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.debug("----exceptionCaught");
        if (null != cause) {
            // 打印异常的堆栈信息
            cause.printStackTrace();
        }
        if (null != ctx) {
            ctx.close();
        }
    }
}
