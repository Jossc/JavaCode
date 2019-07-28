package com.jvm.bytecode.hsdb;

import java.io.IOException;

/**
 * @ClassName VtableTest
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-28 09:41
 **/
public class VtableTest {
    public static void main(String[] args) throws IOException {
        VtableA obj = new VtableB();
        System.in.read();
        System.out.println(obj);
    }

}
