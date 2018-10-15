/**
 * Compare And Swap
 * cas算法：
 *
 *  V表示要更新的变量
 *
 *  E表示预期值
 *
 *  N表示新值
 *
 * 如果V值等于E值，则将V的值设为N。若V值和E值不同，则说明已经有其他线程做了更新，则当前线程什么都不做.
 *
 * 优点：
 *  int mp = os::is_MP();
 *   __asm {
 *     mov edx, dest
 *     mov ecx, exchange_value
 *     mov eax, compare_value
 *     LOCK_IF_MP(mp)
 *     cmpxchg dword ptr [edx], ecx
 *   }
 *   会自己判断需不需要加lock
 * 1.lock free 实现了java层面无锁(cas 在底层实使用exchange_value 指令 自己会判断需不需要加锁)
 * 2.非阻塞。
 * 缺点：
 * 1.如果线程竞争激烈的话，cpu的性能会直线下降。
 * 2.会出现ABA的问题。 解决方式直接添加一个version版本。每次修改version+1
 * 3.只能保证单个变量的安全。
 *  *
 * asq队列:
 * 1.内部调用了cas算法
 *
 *
 *
 *
 *
 */
package com.basics.JucTest;
