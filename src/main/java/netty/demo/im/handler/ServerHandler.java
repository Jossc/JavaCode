package netty.demo.im.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author 一方通行
 * @title: ServerHandler
 * @projectName JavaCode
 * @date 2020/8/9 17:11
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(StandardCharsets.UTF_8));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = getByteBuf(ctx);
        ctx.writeAndFlush(byteBuf);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext handlerContext) {
        ByteBuf byteBuf = handlerContext.alloc().buffer();
        byte[] bytes = "哈哈哈 小胖服务器 写回".getBytes(StandardCharsets.UTF_8);
        return byteBuf.writeBytes(bytes);
    }
}
