package com.concurrent.volatilelearn;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/6/27 16:16
 **/
public class ValuationExample {
    static int i;

    public static void main(String[] args) {
        new ValuationExample().write();
        new ValuationExample().read();
    }

    public void write() {
        i = 3;
    }

    public void read() {
        System.err.println(i);
    }
}
