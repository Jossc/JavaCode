package com.evething;

/**
 * @ClassName TestCode
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TestOne {
    private int i;
    private char ch;

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
        for (int i = 0; i < 10; i++) {
            try {
                TestException testException = new TestException(i);
                testException.testException();
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}

class TestException {
    private int i;

    public TestException(int i) {
        this.i = i;
    }

    void testException() {
        if (i == 0) {
            int c = 0 / i;
        } else {
            System.out.println(i);
        }
    }
}
