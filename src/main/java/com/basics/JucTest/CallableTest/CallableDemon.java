package com.basics.JucTest.CallableTest;

import java.util.concurrent.Callable;

/**
 * @ClassName CallableDemon
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/11/1 22:01
 * @Version 1.0
 **/
public class CallableDemon implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("线程在进行计算");
        Thread.sleep(1000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }

}
