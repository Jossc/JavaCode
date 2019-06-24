package com.jvm.classloader.relyclass;

/**
 * @ClassName TestThree
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-16 15:28
 *
 * 数组类型实例，是有jvm在运行期间动态生生成的。
 * 表现形式为 [Lcom.jvm.classloader.relyclass.ParentThree;
 *  一个[+L + com.jvm.classloader.relyclass.ParentThree;
 * 会发现其中的类型就是元素的类型
 * 其父类还是object
 *
 * 助记符:
 *  anewarray : 创建一个引用类型的数组并将其压入栈顶
 *  newarray :创建一个非引用类型的数组并将其压入栈顶
 *
 *
 **/
public class TestThree {
    public static void main(String[] args) {
        ParentThree[] parentThrees = new ParentThree[10];
        System.out.println(parentThrees.getClass());
        ParentThree[][] parentThrees1  = new ParentThree[1][1];
        System.out.println(parentThrees1.getClass());
        int[] count  = new int[10];
        System.out.println(count.getClass());
        System.out.println(count.getClass().getSuperclass());

    }
}

class ParentThree{
    static {
        System.out.println("static code ParentThree");
    }

}