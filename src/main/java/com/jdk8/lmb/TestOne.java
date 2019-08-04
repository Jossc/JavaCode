package com.jdk8.lmb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName TestCode
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TestOne {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Runnable rr;

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });
    }
}
