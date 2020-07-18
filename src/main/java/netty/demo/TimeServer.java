package netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;

/**
 * @author crazy
 * @title: TimeServer
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/7/1711:38
 */
public class TimeServer {

    public static void main(String[] args) throws InterruptedException {
        //创建boos线程 管理worker线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //创建work线程
        EventLoopGroup workGroup = new NioEventLoopGroup();
        //创建服务端
        ServerBootstrap bootstrap = new ServerBootstrap();
        //
        bootstrap.group(bossGroup, workGroup)
                //设置管道类型
                .channel(NioSctpServerChannel.class)
                //设置tcp 参数， 一次1024字节大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                //设置处理channel的处理器
                .childHandler(new ChildChannelHandler());
        //绑定异步回调
        ChannelFuture future = bootstrap.bind().sync();
        future.channel().closeFuture();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }

    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {


        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }
}
