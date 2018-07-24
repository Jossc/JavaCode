package com.basics.ThreadPool;

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
        System.out.println("只是测试" +
                "size ："+ list.size());
       if(!list.isEmpty()){
            System.out.println("??" + list.size());
       }

       boolean booleanTest = true;
       if(booleanTest){
           booleanTest =false;

           System.out.println("----------");
       }
    }
}
