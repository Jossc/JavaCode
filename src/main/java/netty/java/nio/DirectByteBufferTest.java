package netty.java.nio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName DirectByteBufferTestr.java
 * @createTime 2020年07月27日 22:22:00
 */
public class DirectByteBufferTest {

    public static void main(String[] args) {
        test();
    }


    public static void test() {
        List<ByteBuffer> list = new ArrayList<ByteBuffer>();
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1 * 1024 * 1024);
            list.add(buffer);
        }
    }
}
