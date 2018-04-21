package com.basics.ThreadCode.LockSUpport;

import java.util.concurrent.locks.LockSupport;

/**
 * PACKAGE_NAME: com.basics.ThreadCode.LockSUpport
 * MONTH_NAME_SHORT: 四月
 * USER: Clement
 * LockSupport
 * 线程挂起/唤醒线程
 * 每个使用它的线程都会关联一个许可证,
 * 默认调用LockSupport 类的方法的线程是不持有许可证的
 **/
public class LockSupportTest {
    public static void main(String []args){
        System.err.println(" begin park ");
        //添加线程关联
        LockSupport.unpark(Thread.currentThread());
        //没有许可 一直阻塞
        LockSupport.park();
        System.err.println(" edn park");
    }



}
