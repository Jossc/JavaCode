package com.basics.ThreadCode.LockSUpport;

import java.util.concurrent.locks.LockSupport;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.LockSUpport
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/23
 * @author: Jossc
 * jstack + pid 可以看到
 *   - parking to wait for  <0x174ee478>
 *       (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
 */
public class TestPark {
    public void testPark(){
        LockSupport.park();
    }

    public static void  main(String[] args){
        TestPark testPark = new TestPark();
        testPark.testPark();

    }
}
