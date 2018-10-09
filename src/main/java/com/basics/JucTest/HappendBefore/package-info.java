/**
 * PACKAGE_NAME: com.basics.JucTest.HappendBefore
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 * happens before 原则
 * as-if-serial 语义:在单线程的情况下无论怎么重排序 结果都不会变。
 *
 * happens before 原则:
 * 1.程序执行规则：一个线程中的每个操作，happens-before于该线程中的任意后续操作
 * 注: 这里可以理解成 对as-if-serial语意的封装
 *
 * 2.监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁
 * 注：同1

 * 3.volatile变量规则：对一个volatile域的写，happens-before于任意后续对这个volatile域的读
 * 注: volatile变量的修改任意线程可见,所以保证了这里的的写 happens-before与 这个volatile变量的读
 *
 * 4.传递性：如果A happens-before B，且B happens-before C，那么A happens-before C
 * 注： a+b=c 在单线程的情况下 无论怎么重排序c的结果不变(as-if-serial语义)
 * 但是在多线程的情况下,会发生重排序,volatile包插入了内存屏障来禁止了重排序 所以A happens-before C
 *
 * 5.start()规则：如果线程A执行操作ThreadB.start()（启动线程B），那么A线程的
 * ThreadB.start()操作happens-before于线程B中的任意操作
 * 注: 我觉得5.6差不多，在多线程的情况下,A线程启动操作变量 永远都happens-before B线程
 * 启动的操作变量。join同理
 * 6.join()规则：如果线程A执行操作ThreadB.join()并成功返回，那么线程B中的任意操作
 * happens-before于线程A从ThreadB.join()操作成功返回。
 *
 **/
package com.basics.JucTest.HappendBefore;