/**
 * PACKAGE_NAME: com.basics.ThreadLocalTest
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 * ThreadLocal
 * ThreadLocal内使用ThreadLocalMap来维护线程与
 * ThreadLocal的关系(key---value)的形式
 * ThreadLocal的变量存放在Thread中
 * 证明:{@link java.lang.Thread}中
 * ThreadLocal.ThreadLocalMap threadLocals = null;
 * 在ThreadLocalMap 中的getMap方法 所以不要让一些博客误导。
 * ThreadLocalMap getMap(Thread t) {
 *         return t.threadLocals;
 * }
 * //set方法
 * public void set(T value) {
 *         获取当前线程
 *         Thread t = Thread.currentThread();
 *         与当前线程形成key ---value 的关系
 *         ThreadLocalMap map = getMap(t);
 *         如果map不是空的那么直接就set新值进去，
 *         如果map是空的那么久直接创建值。
 *         if (map != null)
 *             map.set(this, value);
 *         else
 *             createMap(t, value);
 *     }
 * {@link java.lang.ThreadLocal}
 **/
package com.basics.ThreadLocalTest;