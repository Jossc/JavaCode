package com.basics.queue.QueueQu.DelayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * PACKAGE_NAME: com.basics.queue.QueueQu.DelayQueue
 * MONTH_NAME_SHORT: 十二月
 * USER: Clement
 **/
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue queue  = new DelayQueue();
        queue.add(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return unit.toMillis(1000);
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });
    }
}
