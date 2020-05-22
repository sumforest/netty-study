package com.sen.netty.study.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author: Sen
 * @date 2020/5/22 0022 20:31
 * @description: 创建解码器
 */
public class LiveDecoder extends ReplayingDecoder<LiveMessage> {


    /**
     * 自定义解码逻辑
     *
     * @author: Sen
     * @date: 2020/5/22 0022 20:33
     * @param: [channelHandlerContext, byteBuf, list]
     * @return: void
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

    }
}
