package com.sen.netty.study.socket;

/**
 * @author: Sen
 * @date 2020/5/22 0022 20:24
 * @description: 定义消息类型
 */
public class LiveMessage {

    /**
     * 心跳类型信息
     */
    public static final byte TYPE_HEART = 1;

    /**
     * 消息类型信息
     */
    public static final byte TYPE_MESSAGE = 2;

    /**
     * 表示消息的类型，有心跳类型和内容类型
     */
    private byte type;

    private int length;

    private String content;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LiveMessage{" +
                "type=" + type +
                ", length=" + length +
                ", content='" + content + '\'' +
                '}';
    }
}
