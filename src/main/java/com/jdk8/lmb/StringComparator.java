package com.jdk8.lmb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName StringComparator
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * 字符串比较
 **/
public class StringComparator {
    public static void main(String[] args) {
        List<String> lists = Arrays.asList("mafiefei","sunpipi","sunpiyi");
        Collections.sort(lists,(s1,s2)->{
            return s2.compareTo(s1);
        });
        Collections.sort(lists,Collections.reverseOrder());
        lists.forEach(s -> System.out.println(s));

    }
}
