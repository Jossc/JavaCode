package com.basics.ThreadCode.ThreadDemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SleepUtils
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/9 15:41
 * @Version 1.0
 **/
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
