package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author crazy
 * @title: HttpHelloWorldServer
 * @projectName JavaCode
 * @description: netty自定义webService 简陋版
 *
 * @date 2020/5/3014:43
 */
public class HttpHelloWorldServer {

    private static final int THREAD_NUMBER = 1;

    public   static void main(String[] args) {
        try {
            EventLoopGroup bossGroup = new NioEventLoopGroup(THREAD_NUMBER);
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new HttpServerCodec());
                            p.addLast(new HttpServerExpectContinueHandler());
                            p.addLast(new HttpHelloWorldServerHandler());
                        }
                    });

            Channel ch = bootstrap.bind(8080).sync().channel();
            System.err.println("Open your web browser and navigate to " +
                    "http://127.0.0.1:8080");

            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
