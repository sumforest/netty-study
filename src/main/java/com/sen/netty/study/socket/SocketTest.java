package com.sen.netty.study.socket;

import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author: Sen
 * @date 2020/5/23 0023 10:53
 * @description: 长连接测试
 */
public class SocketTest {

    private static Logger log = LoggerFactory.getLogger(SocketTest.class);

    String host = "127.0.0.1";
    int port = 8080;

    public void testSocket() throws IOException {
        final Socket socket = new Socket();
        // 连接服务端
        socket.connect(new InetSocketAddress(host, port));
        Scanner scanner = new Scanner(System.in);
        // 启动一个线程来接收socket内容
        new Thread(() -> {
            while (true) {
                byte[] input = new byte[64];
                try {
                    int readByte = socket.getInputStream().read(input);
                    log.debug("----readByte: " + readByte);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        int result;
        while (true) {
            result = scanner.nextInt();
            log.debug("----input code:{}", result);
            if (result == 0) {
                break;
                // 往socket写入心跳
            } else if (result == 1) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                byteBuffer.put((byte) 1);
                byteBuffer.putInt(0);
                // 把数据写出去
                socket.getOutputStream().write(byteBuffer.array());
                log.debug("----write heart beat finish!");
                // 往socket写入消息
            } else if (result == 2) {
                byte[] content = ("hello I am " + this.hashCode()).getBytes();
                ByteBuffer byteBuffer = ByteBuffer.allocate(content.length + 5);
                // 写入消息类型为2
                byteBuffer.put((byte) 2);
                // 写入消息长度
                byteBuffer.putInt(content.length);
                // 写入消息
                byteBuffer.put(content);
                socket.getOutputStream().write(byteBuffer.array());
                log.debug("----write message finished!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 启动客户单
        new SocketTest().testSocket();
    }
}
