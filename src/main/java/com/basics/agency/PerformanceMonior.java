package com.basics.agency;

/**
 * @PACKAGE_NAME: com.basics
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 * 拦截明细
 */
public class PerformanceMonior {
    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal();
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformace mp = performaceRecord.get();
        if (mp == null) {
            mp = new MethodPerformace(method);
            performaceRecord.set(mp);
        } else {
            mp.reset(method);
        }
    }
    public static void end() {
        System.out.println("end monitor...");
        MethodPerformace mp = performaceRecord.get();
        mp.printPerformace();
    }
}
