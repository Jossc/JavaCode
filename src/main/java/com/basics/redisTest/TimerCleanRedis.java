package com.basics.redisTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @PACKAGE_NAME: com.basics.redisTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/19
 * @author: Jossc
 */
public class TimerCleanRedis {
    static  int count = 0;

    public static void showTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ++count;
                System.out.println("时间=" + new Date() + " 执行了" + count + "次"); // 1次
            }
        };
        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的00:00:00执行，
        calendar.set(year, month, day, 00, 00, 00);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        System.out.println(date);

        int period = 2 * 1000;
        timer.schedule(task, date, period);
        //每天的date时刻执行task, 仅执行一次
        //timer.schedule(task, date);
    }

    public static void main(String[] args) {
        showTimer();
    }
}
