package com.basics.ThreadCode.ThreadLocalDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName InterruptThreadTest
 * @Description TODO 测试I nterrupt
 * @Author chenzhuo
 * @Date 2018/8/10 11:45
 * @Version 1.0
 **/
public class InterruptThreadTest {
    private final static  Logger logger = LoggerFactory.getLogger(InterruptThreadTest.class);
    public static void main(String []args){

      /*
        一个安全都没有
        SecurityManager security = System.getSecurityManager();
        ThreadGroup threadGroup = security.getThreadGroup();
        System.out.println("threadGroup :" +threadGroup.getName());
        System.out.println("name :" + security.getSecurityContext().getClass()
        .getName());
        */
      getInterruptThread();

    }

    public static void  getInterruptThread(){
        try {
            boolean interrupted = Thread.interrupted();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }
    }
}
