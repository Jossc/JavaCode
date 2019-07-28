package com.basics.juctest.HappendBefore;

/**
 * PACKAGE_NAME: com.basics.juctest.HappendBefore
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 *  return new DoubleDetection();
 *  的时候有3个操作
 *  1.分配内存地址
 *  2.初始化对象
 *  3.设置内存指向
 * 再多线程的情况下  可能发生 2 3 重排序
 *
 **/
public class DoubleDetectionError {
    public static DoubleDetection doubleDetection;

    public static  DoubleDetection getDoubleDetection(){
        if(doubleDetection ==null ){
            synchronized (DoubleDetection.class){
                return new DoubleDetection();
            }
        }
        return doubleDetection;
    }
}
