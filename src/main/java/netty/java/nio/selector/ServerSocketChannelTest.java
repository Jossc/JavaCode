package netty.java.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author crazy
 * @title: ServerSocketChannelTest
 * @projectName JavaCode
 * @description: nio Test
 * @date 2020/7/921:56
 */
public class ServerSocketChannelTest {

    private static final String ADDRESS = "localhost";

    private static final int PORT = 8800;


    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定一个地址
        serverSocketChannel.bind(new InetSocketAddress(ADDRESS, PORT));
        //设置是否阻塞
        serverSocketChannel.configureBlocking(false);
        while (true) {
            //创建基本监听
            SocketChannel serverSocket = serverSocketChannel.accept();
        }

    }
}
