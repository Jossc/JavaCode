package com.basics.JucTest.Final;

/**
 * @ClassName FinalTest
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/1 19:33
 * @Version 1.0
 * 详解请看{@link com.basics.JucTest.Final}
 *
 * 
 **/
public class FinalTest {
    //普通变量
    int i ;
    //final 变量
    final int j;
    static  FinalTest finalTest;

    public FinalTest(){
      i = 10;
      j = 15;
    }
    public static void wirte(){
        finalTest = new FinalTest();
    }
    public static  void read(){
        FinalTest finalTest1 = finalTest;
        int a = finalTest1.i;
        System.out.println("a:" +  a);
        int b = finalTest1.j;
        System.out.println("b :" +b);
    }
}
