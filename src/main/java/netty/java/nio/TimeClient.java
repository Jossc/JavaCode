package netty.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName TimeClient
 * @Description Java nio client
 * @Author Crazy
 * @Date 2020/6/22 22:29
 */
public class TimeClient {

    private static final int PORT = 9093;

    public static void main(String[] args) throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("localhost", PORT);
        SocketChannel socketChannel = SocketChannel.open();
        SocketChannel channel = SocketChannel.open();
        channel.bind(socketAddress);
        channel.connect(socketAddress);
        //非阻塞模式
        channel.configureBlocking(false);
        System.out.println(channel.isOpen());
    }
}
