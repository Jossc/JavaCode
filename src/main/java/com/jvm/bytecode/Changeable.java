package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description 可变参数
 * @Date 2019/7/9 14:12
 **/
abstract class Changeable {
    /**
     * 有意思的代码
     *
     * @param obj
     * @param args
     */
    abstract void invoke(Object obj, Object... args);

    /**
     * 有意思的代码2
     *
     * @param s      s
     * @param object obj
     * @param args   args
     */
    abstract void invoke(String s, Object object, Object... args);
}
