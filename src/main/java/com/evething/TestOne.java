package com.evething;

/**
 * @ClassName TestOne
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TestOne {
    private int i;
    private char ch ;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public static void main(String[] args) {
        TestOne testOne = new TestOne();
        System.out.println(testOne.getI());
        System.out.println(testOne.getI());
    }
}
