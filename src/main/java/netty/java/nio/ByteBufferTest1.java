package netty.java.nio;


import java.nio.ByteBuffer;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName ByteBufferTest1.java
 * @createTime 2020年07月26日 17:19:00
 */
public class ByteBufferTest1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //直接缓冲区 直接在内存汇总
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        Class c = java.nio.Bits.class;
    }
}
