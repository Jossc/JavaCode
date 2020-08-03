package netty.java.nio;

import java.nio.CharBuffer;

/**
 * @author crazy
 * @title: BufferTest
 * @projectName JavaCode
 * @description: TODO
 * @date 2020/6/2414:18
 */
public class BufferTest {

    public static void main(String[] args) {
        //创建8个长度的
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("capacity :" + buffer.capacity());
        System.out.println("limit : " + buffer.limit());
        System.out.println("position : " + buffer.position());
        System.out.println("make  : " + buffer.mark());
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        buffer.reset();
        System.out.println("加入三个元素 position :" + buffer.position());
        buffer.flip();
        System.out.println("执行flip 后:limit = " + buffer.limit());
        System.out.println("取出第一个元素position=0 " +
                buffer.get());
        System.out.println("取出第一个元素后position : " + buffer.position());
        buffer.clear();
        System.out.println("clear limit : "+ buffer.limit());
        System.out.println("clear position : "+ buffer.position());
        System.out.println("clear buffer : "+ buffer.get(2));
        System.out.println("执行index读取后:" + buffer.position());
    }
}
