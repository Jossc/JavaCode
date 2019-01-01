package com.sun.jvm.Jvm.returnAddress;

import java.util.concurrent.*;

/**
 * @ClassName TestJavaP
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TestJavaP {
    private int tryBack;
    public  long callableBack;
    protected double finallBack;
    private  int methodNumber ;

    public static  final  TestJavaP TEST_JAVA_P  = initTestJavaP();
    public static TestJavaP initTestJavaP(){
        return new TestJavaP();
    }

    public static void main(String[] args) {
        TestJavaP testJavaP = new TestJavaP();
        testJavaP.test();
        testJavaP.runnableTest();
    }

    public void runnableTest(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,20, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        for (int i=0;i<100;i++){
            int finalI = i;
            threadPoolExecutor.execute(()->{
                System.out.println(finalI);
                TestJavaP testJavaP = new TestJavaP();
            });
        }

        threadPoolExecutor.shutdown();
    }


    public void test(){
        try {
            tryBack=2;
        }catch (Exception e){
            callableBack = 1;
        }finally {
            finallBack =3;
        }
        methodNumber =10;
    }
}
