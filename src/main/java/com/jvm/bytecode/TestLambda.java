package com.jvm.bytecode;

/**
 * @ClassName TestLambda
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-28 22:01
 *  private static void lambda$main$0();
 *     descriptor: ()V
 *     flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
 *     Code:
 *       stack=2, locals=0, args_size=0
 *          0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #5                  // String hello, lambda
 *          5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 13: 0
 *         line 14: 8
 *
 *      private static void lambda$main$0() {
 *         System.out.println("hello, lambda");
 *      }
 *
 **/
public class TestLambda {

    public static void main(String[] args) {

        Runnable r = ()->{
            System.out.println("hello, lambda");
        };
        r.run();
    }
}
