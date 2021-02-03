package org.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName ConnectHandler
 * @Deacription TODO
 * @Author chen-guang.liu
 * @Date 2021/2/2 15:12
 * @Version 1.0
 **/
public class ConnectHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client "+ctx.channel().remoteAddress()+" connected");
//        super.channelActive(ctx);
    }
}
