package netty.demo.im.handler;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author 一方通行
 * @title: ClientHandler
 * @projectName JavaCode
 * @date 2020/8/9 17:01
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": 客户端写出数据");
        ByteBuf byteBuf = getByteBuf(ctx);
        ctx.channel().writeAndFlush(byteBuf);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(StandardCharsets.UTF_8));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
        byte[] bytes = "哈哈 小胖的测试!".getBytes(StandardCharsets.UTF_8);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}
