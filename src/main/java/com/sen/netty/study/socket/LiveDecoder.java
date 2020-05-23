package com.sen.netty.study.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: Sen
 * @date 2020/5/22 0022 20:31
 * @description: 创建解码器
 */
public class LiveDecoder extends ReplayingDecoder<LiveDecoder.LiveState> {

    Logger log = LoggerFactory.getLogger(LiveDecoder.class);

    /**
     * handler状态枚举类
     */
    public enum LiveState {
        /**
         * 当前状态为消息类型
         */
        TYPE,
        /**
         * 当前状态类型为长度
         */
        LENGTH,
        /**
         * 当前状态为消息内容
         */
        CONTENT
    }

    /**
     * 消息
     */
    private LiveMessage message;

    public LiveDecoder() {
        // 调用父类构造方法
        super(LiveState.TYPE);
    }

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
        // 获取状态
        LiveState state = super.state();
        log.debug("----state: {},message: {}", state, this.message);
        // 判断状态
        switch (state) {
            // 设置消息类型
            case TYPE:
                this.message = new LiveMessage();
                // 从buff中读取消息类型
                byte type = byteBuf.readByte();
                log.debug("----type: {}", type);
                // 设置消息类型
                this.message.setType(type);
                // 设置当前接收数据状态为长度
                super.checkpoint(LiveState.LENGTH);
                break;
            // 设置消息长度
            case LENGTH:
                int length = byteBuf.readInt();
                // 设置消息长度
                this.message.setLength(length);
                // 长度读取完成
                if (length > 0) {
                    // 设置handler状态为读取消息
                    super.checkpoint(LiveState.CONTENT);
                }else{
                    // 当前消息为读取完，把消息片段加入集合
                    list.add(message);
                    // 更改handler状态为type
                    super.checkpoint(LiveState.TYPE);
                }
                break;
            // 读取内容
            case CONTENT:
                byte[] bytes = new byte[message.getLength()];
                // 把buf中的内容读入二进制数组
                byteBuf.readBytes(bytes);
                String content = new String(bytes);
                this.message.setContent(content);
                // 把message加入消息集合
                list.add(message);
                // 更新handler状态为读取type
                super.checkpoint(LiveState.TYPE);
                break;
            default:
                throw new IllegalStateException("invalid state: + " + state);
        }
        log.debug("----end state: {},list: {}", state, list);
    }
}
