package netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author crazy
 * @title: TimeServerHandler
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/7/17 15:18
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] reg = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(reg);
        String body = new String(reg, StandardCharsets.UTF_8);

    } 

}
