package com.jdk8.invokedynamic;

import java.util.Arrays;

/**
 * @ClassName RunTestls
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/2 11:16 下午
 **/
public class RunTest {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println(Arrays.toString(args));
        r.run();
    }

}
