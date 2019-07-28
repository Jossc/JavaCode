package com.concurrent.thread.finalthread;

/**
 * @ClassName FinalReferneceExample
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-21 20:57
 **/
public class FinalReferneceExample {
    int i;

    static FinalReferneceExample finalReferneceExample;

    public FinalReferneceExample() {
        i = 1;
        finalReferneceExample = this;
    }

    public static void writer() {
        new FinalReferneceExample();
    }

    public static void reader() {
        if (finalReferneceExample != null) {
            int temp = finalReferneceExample.i;
            System.out.println("temp :" + temp);
        } else {
            System.out.println("is null");
        }
    }

    public static void main(String[] args) {
        /**
         *  第一步先new  一下 其实就是开辟空间
         *
         *  第二步dup,为复制操作数栈顶值，并将其压入栈顶，也就是说此时操作数栈上有连续相同的两个对象地址。
         *  第三步 调用实例初始化方法<init>，这时候会弹出来一个对象地址
         *  第四步 就加载栈顶的的变量
         *  0: new           #4                  // class com/concurrent/thread/finalthread/FinalReferneceExample
         *  3: dup
         *  4: invokespecial #5                  // Method "<init>":()V
         *  7: astore_1
         *  8: return
         */
       FinalReferneceExample finalReferneceExample = new FinalReferneceExample();
    }
}
