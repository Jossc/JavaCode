package com.sun.jvm.Jvm.returnAddress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @ClassName ReturnAddressTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 *
 **/
public class ReturnAddressTest {
    public static void main(String[] args) {
        try (InputStream o = new FileInputStream("E:\\Java虚拟机规范(Java SE 8版)(带书签完整版)\\Java虚拟机规范(Java SE 8版)(带书签完整版).pdf")){
            System.out.println("hello word");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
