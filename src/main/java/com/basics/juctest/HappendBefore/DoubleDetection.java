package com.basics.juctest.HappendBefore;

/**
 * PACKAGE_NAME: com.basics.juctest.HappendBefore
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 * 并发中正确的使用双重检测
 * 使用volatile 语义
 **/
public class DoubleDetection {

    public volatile static DoubleDetection doubleDetection;
    public static DoubleDetection getDouble(){
        if(doubleDetection==null){
            synchronized (DoubleDetection.class){
               if(doubleDetection ==null){
                   return  new DoubleDetection();
               }
            }
        }
        return doubleDetection;
    }

}