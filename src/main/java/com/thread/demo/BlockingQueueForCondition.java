package com.thread.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author crazy
 * @title: BlockingQueueForCondition
 * @projectName JavaCode
 * @description: 自定义实现生产和消费者
 * @date 2020/7/20 14:43
 */
public class BlockingQueueForCondition {

    private Queue queue;

    private int maxSize = 16;

    private ReentrantLock lock = new ReentrantLock();

    private Condition isNull = lock.newCondition();

    private Condition isFull = lock.newCondition();

    public BlockingQueueForCondition(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList();
    }


    public static void main(String[] args) {

    }

    public void putValue(String value) {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                isFull.await();
            }
            queue.add(value);
            isNull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  String getValue() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                isNull.await();
            }
            String value = (String) queue.remove();
            isFull.signalAll();
            return value;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return null;
    }
}
