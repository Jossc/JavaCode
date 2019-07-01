package com.match;

/**
 * @ClassName: ConextClassLoadTest
 * @Description TODO
 * @Date 2019/1/23 17:02
 * @Created by chenzhuo
 **/
public class ConextClassLoadTest {

    public static ClassLoader getThreadConextClassLoad(Thread  thread){
       return thread.getContextClassLoader();
    }



}
