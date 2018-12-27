package com.basics.queue.QueueQu.DelayQueue.queueInterface;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * PACKAGE_NAME: com.basics.queue.QueueQu.DelayQueue.queueInterface
 * MONTH_NAME_SHORT: 十二月
 * USER: Clement
 **/
public class DelayQueueInterface implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
