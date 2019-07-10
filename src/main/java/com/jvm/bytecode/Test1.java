package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/8 17:19
 **/
public class Test1 {

    public Test1() {

    }

    /**
     *  public com.jvm.bytecode.Test1();
     *     Code:
     *        0: aload_0
     *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *        4: return
     *
     *   public static void main(java.lang.String[]);
     *     Code:
     *       new的指令
     *        0: new           #2                  // class com/jvm/bytecode/Test1
     *        把Test1的栈压入栈顶,如果不压入，astore_1会找不见位置
     *        3: dup
     *        初始化
     *        4: invokespecial #3                  // Method "<init>":()V
     *        //将栈顶引用类型值保存到局部变量1中。
     *        7: astore_1
     *        8: return
     * @param args
     */
    public static void main(String[] args) {
        Test1 test1 = new Test1();

    }
}
