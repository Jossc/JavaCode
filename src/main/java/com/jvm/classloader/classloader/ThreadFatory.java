package com.jvm.classloader.classloader;

import java.util.concurrent.ThreadFactory;

/**
 * @ClassName ThreadFatory
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-20 22:17
 **/
public class ThreadFatory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
