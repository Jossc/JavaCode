package com.basics.redisTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @PACKAGE_NAME: com.basics.redisTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/23
 * @author: Jossc
 * 定时器执行
 */
public class TimerRunTask  extends TimerTask {
    private  static Logger logger = LoggerFactory.getLogger(TimerRunTask.class);
    @Override
    public void run() {
        try {
            logger.error("测试定时任务~~~~~~~~~~");
            System.err.println(" hello ----- word ");
        }catch (Exception e){

        }

    }
}
