package com.sun.jvm.Jvm;

import java.nio.ByteBuffer;

/**
 * @ClassName AccessDirectBuffer
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * 堆外内存的使用
 * 堆外内存要比直接使用堆内存快
 * 但是堆外内存要限制使用的量，要不就会oom
 **/
public class AccessDirectBuffer {
    public void directAccess(){
        long startTime = System.currentTimeMillis();
        testWrite();
        long endTime = System.currentTimeMillis();
        System.out.println("testDirectWrite:" + (endTime - startTime));
    }
    public void bufferAccess(){
        long startTime = System.currentTimeMillis();
        testWrite();
        long endTime = System.currentTimeMillis();
        System.out.println("testBufferWrite:" + (endTime - startTime));
    }

    private void testWrite() {

        ByteBuffer byteBudder = ByteBuffer.allocateDirect(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                byteBudder.putInt(j);
            }
            byteBudder.flip();
            for (int j = 0; j < 99; j++) {
                byteBudder.get();
            }
            byteBudder.clear();
        }
        long endTime = System.currentTimeMillis();

    }

    public static void main(String[] args) {
        AccessDirectBuffer accessDirectBuffer = new AccessDirectBuffer();
        accessDirectBuffer.bufferAccess();;
        accessDirectBuffer.directAccess();
    }
}
