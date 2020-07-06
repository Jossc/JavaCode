package netty.java.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author crazy
 * @title: EPollClient
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/7/611:36
 */
public class EPollClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

        ByteBuffer writeBuffer = ByteBuffer.allocate(32);
        ByteBuffer readBuffer = ByteBuffer.allocate(32);
        writeBuffer.put("hello".getBytes());
        writeBuffer.flip();
        while (true) {
            writeBuffer.rewind();
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            readBuffer.clear();
            socketChannel.read(readBuffer);
        }
    }
}
