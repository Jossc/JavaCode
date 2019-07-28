package com.basics.juctest.HappendBefore;

/**
 * PACKAGE_NAME: com.basics.juctest.HappendBefore
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class DoubleDetectionTwo {
    public static DoubleDetection doubleDetection;
    public DoubleDetectionTwo(){
        doubleDetection = new DoubleDetection();
    }

    /**
     * 在多线程的情况下 如果执行
     * A B两个线程
     *
     * a加载的时候会获取class锁
     * b就等待 所以这么写没问题
     * @return
     */
    public static DoubleDetection getDoubleDetection() {
        return DoubleDetectionTwo.doubleDetection;
    }
}
