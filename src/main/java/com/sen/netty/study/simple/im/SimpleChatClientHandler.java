package com.sen.netty.study.simple.im;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Sen
 * @date 2020/5/23 0023 16:28
 * @description: 客户端处理IO
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {

    private static final Logger log = LoggerFactory.getLogger(SimpleChatServerHandler.class);

    /**
     * 客户端接收到信息直接输出
     *
     * @author: Sen
     * @date: 2020/5/23 0023 16:39
     * @param: [ctx, msg]
     * @return: void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.error("{}",msg);
    }
}
