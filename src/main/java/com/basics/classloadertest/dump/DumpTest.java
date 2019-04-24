package com.basics.classloadertest.dump;

import java.util.*;

/**
 * @ClassName DumpTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/12 11:25
 * @Version 1.0
 *
 * -XX:PermSize=1m  -XX:MaxPermSize=1m   -XX:+HeapDumpOnOutOfMemoryError
 **/
public class DumpTest {

    static class OOMIntsmaze {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(ArrayList<OOMIntsmaze> list, int num) throws Exception {

        for (int i = 0; i < num; i++) {
            list.add(new OOMIntsmaze());
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        int i = 0;
        while(true){
            list.add(i++);
        }

    }
}
