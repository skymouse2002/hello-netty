package org.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName EchoServerHandler
 * @Deacription TODO
 * @Author chen-guang.liu
 * @Date 2021/2/3 15:23
 * @Version 1.0
 **/
//标示一个ChannelHandler可以被多个 Channel 安全地共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in=(ByteBuf) msg;
        System.out.println("Server received: "+in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
//        super.channelRead(ctx, msg);
    }

    /**
     * 将未决小小冲刷到远程节点，并关闭该channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
//        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印异常栈跟踪
        ctx.close();//关闭该Channel
//        super.exceptionCaught(ctx, cause);
    }
}
