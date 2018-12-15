package com.sun.jvm.Jvm;

import java.util.Vector;

/**
 * @ClassName DumpOOM
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class DumpOOM {
    public static void main(String[] args) {
        Vector<byte[]> vector = new Vector<>();
        for (int i =0;i<25;i++){
            vector.add(new byte[1024*1024]);
        }

    }
}
