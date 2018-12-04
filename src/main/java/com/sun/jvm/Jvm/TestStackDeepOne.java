package com.sun.jvm.Jvm;

/**
 * @ClassName TestStaackDeep
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * 错误递归导致栈溢出
 * -Xss128k 线程栈大小
 **/
public class TestStackDeepOne {
    private  static  int count=0;
    public static  void recursion(){
        count ++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        }catch (Throwable throwable){
            System.out.println("deep od calling = " +count);
            throwable.printStackTrace();
        }
    }
}
