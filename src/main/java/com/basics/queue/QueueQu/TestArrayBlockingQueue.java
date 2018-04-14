package com.basics.queue.QueueQu;

/**
 *
 * 有界阻塞队列ArrayBlockingQueue
 * 使用ReentrantLock 可重入锁保证线程安全
 * size 是精准的size的时候调用了块锁
 * ArrayBlockingQueue（有界阻塞队列）内部使用数组 来限制其长度
 * 保证线程安全的做法和使用synchronized雷同
 * ConcurrentLinkedQueue（无界非阻塞队列）的size是不精准的
 * 但是 使用cas效率更高，适应高并发场景
 *
 * 阻塞： 使用锁来实现
 * 非阻塞：使用cas等算法来实现
 *
 */
public class TestArrayBlockingQueue {

}
