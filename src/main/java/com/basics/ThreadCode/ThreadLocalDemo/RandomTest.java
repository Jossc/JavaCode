package com.basics.ThreadCode.ThreadLocalDemo;

import java.util.Random;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.ThreadLocalDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/12
 * @author: chenzhuo
 * Random 本地线程变量随机数
 * Random next 是cas操作
 * 多线程的时候会进行自旋操作
 * 所以使用ThreadLocalRandom
 */
public class RandomTest {
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(5));
        }
    }
}
