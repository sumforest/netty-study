package com.sen.netty.study.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.StringUtil;

/**
 * @author: Sen
 * @date 2020/5/22 0022 20:20
 * @description: 创建编码器
 */
public class LiveEncoder extends MessageToByteEncoder<LiveMessage> {

    /**
     * 自定义编码逻辑
     *
     * @author: Sen
     * @date: 2020/5/22 0022 20:28
     * @param: [channelHandlerContext, liveMessage, byteBuf]
     * @return: void
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, LiveMessage liveMessage, ByteBuf byteBuf) throws Exception {
        // 编码LiveMessage的类型
        byteBuf.writeByte(liveMessage.getType());
        // 编码LiveMessage的长度
        byteBuf.writeInt(liveMessage.getLength());
        // 消息存在编码消息内容
        if (!StringUtil.isNullOrEmpty(liveMessage.getContent())) {
            byteBuf.writeBytes(liveMessage.getContent().getBytes());
        }
    }
}
