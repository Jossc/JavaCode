package com.basics.ThreadCode.ThreadDemo;

/**
 * @ClassName TimeWaiting
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/9 15:40
 * @Version 1.0
 **/
public class TimeWaiting implements  Runnable {
    @Override
    public void run() {
        while (true){
            SleepUtils.second(100);
        }
    }
}
