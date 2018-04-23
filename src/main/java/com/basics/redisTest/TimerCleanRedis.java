package com.basics.redisTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @PACKAGE_NAME: com.basics.redisTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/19
 * @author: Jossc
 * 定时任务
 */
public class TimerCleanRedis {
    private  static  final  long  PERIOD_DAY
              = 24 * 60 * 60 * 1000;
    public TimerCleanRedis(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,00);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date date = calendar.getTime();
        /**
         * 判断时间， 如果第一次执行定时任务，
         * 然后加一天 不加，第二天会立即执行
         */
        if(date.before(new Date())){
            date = this.addDay(date,1);
        }
        Timer timer = new Timer();
        TimerRunTask timerRunTask = new TimerRunTask();
        timer.schedule(timerRunTask,date,PERIOD_DAY);
    }
    public static void main(String[] args) {
        new TimerCleanRedis();
    }

    public Date addDay(Date date , int num){
        Calendar startDt = Calendar.getInstance();
        startDt.setTime(date);
        startDt.add(Calendar.DAY_OF_MONTH,num);
        return  startDt.getTime();
    }
}
