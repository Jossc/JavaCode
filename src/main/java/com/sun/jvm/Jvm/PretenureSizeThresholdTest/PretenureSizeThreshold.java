package com.sun.jvm.Jvm.PretenureSizeThresholdTest;

/**
 * @ClassName PretenureSizeThreshold
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * -verbose:gc-Xms20M-Xmx20M-Xmn10M-XX:+PrintGCDetails-XX:SurvivorRatio=8
 *
 * **-XX:PretenureSizeThreshold=3145728
 **/
public class PretenureSizeThreshold {

    public static void main(String[] args) {
    }
    public static void testPretenureSizeThreshold(){
        byte[] a ;
        a = new byte[4*1024];
    }
}
