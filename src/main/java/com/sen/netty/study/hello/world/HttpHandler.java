package com.sen.netty.study.hello.world;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.AsciiString;

/**
 * @author: Sen
 * @date 2020/5/22 14:13
 * @description: 自定义Netty处理逻辑
 */
public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        System.out.printf("接收到请求，处理类class: %s", fullHttpRequest.getClass().getName());
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer("test".getBytes()));
        HttpHeaders headers = defaultFullHttpResponse.headers();
        // 设置响应头字符集
        headers.add(HttpHeaderNames.CONTENT_TYPE, contentType + ";charset=UTF-8");
        // 设置响应头内容长度,添加header描述length。这一步是很重要的一步，如果没有这一步，你会发现用postman发出请求之后就一直在刷新，因为http请求方不知道返回的数据到底有多长。
        headers.add(HttpHeaderNames.CONTENT_LENGTH, defaultFullHttpResponse.content().readableBytes());
        // 设置响应头头是否开启长连接
        headers.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

        // 向客户端响应消息
        channelHandlerContext.write(defaultFullHttpResponse);
    }

    /**
     * 重写读取完成之后事件
     * @param ctx channel上下文处理器
     * @throws Exception 异常抛出
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete");
        super.channelReadComplete(ctx);
        // channel读取完成之后需要输出缓冲流。如果没有这一步，你会发现postman同样会一直在刷新。
        ctx.flush();
    }

    /**
     * 重写异常处理流程
     * @param ctx channel上下文处理器
     * @param cause 捕获的异常，没有异常抛出时为null
     * @throws Exception 抛出异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
        // 捕获异常不为空
        if (cause != null) {
            // 输出异常堆栈信息
            cause.printStackTrace();
        }
        // 通道不为空，关闭通道
        if (ctx != null) {
            ctx.close();
        }
    }
}
