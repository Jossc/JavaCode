package com.basics.JavaassistTest;

/**
 * PACKAGENAME: com.basics.JavaassistTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 八月
 * 逆向基础------
 *java  -verbose:class SingTest
 **/
public class SingTest {
    public SingTest() {

    }
    private static class LazeHolder{
        static final SingTest INSTANCE = new SingTest();
        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }
    public static Object getInstance(boolean flag){
        if(flag) return new LazeHolder[2];
        return LazeHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("-------------");
        getInstance(false);

        Thread thread = new Thread();
       // thread.threadLocalRandomSeed;
    }

}
