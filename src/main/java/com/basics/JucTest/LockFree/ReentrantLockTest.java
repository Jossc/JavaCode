package com.basics.JucTest.LockFree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PACKAGE_NAME: com.basics.JucTest.LockFree
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class ReentrantLockTest extends ReentrantLock {
    public ReentrantLockTest(boolean fair){
        super(fair);
    }
    public Collection<Thread> getQueue(){
        List<Thread> threadList
                = new ArrayList<>(super.getQueuedThreads());
        Collections.reverse(threadList);
        return  threadList;
    }
}
