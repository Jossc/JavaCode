package netty.java.nio;

import java.nio.ByteBuffer;

/**
 * @author crazy
 * @title: ByteBufferTest
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/6/2311:46
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        /*ByteBuffer byteBuffer = ByteBuffer.allocate();*/
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = new byte[10];
        bytes[0] = 1;
        byteBuffer.put(bytes);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        byteBuffer.limit(100);
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.mark());
        System.out.println(byteBuffer.remaining());


    }
}
