package com.basics.ThreadPool;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * PACKAGENAME: com.basics.ThreadPool
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 七月
 * threadPool 测试
 **/
public class ThreadPoolTest {
    public static  void main(String []args){
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println("只是测试size ："+ list.size());
       if(!list.isEmpty()){
            System.out.println("??" + list.size());
       }
       //boolean 会变编译成 1
       boolean booleanTest = true;
       if(booleanTest){
           booleanTest =false;
           System.out.println("----------");
       }
        ThreadPool threadPool ;
    }
}
