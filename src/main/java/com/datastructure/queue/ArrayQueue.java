package com.datastructure.queue;

/**
 * 顺序队列
 *
 * @ClassName ArrayQueue
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/11 12:53 下午
 **/
public class ArrayQueue {

    private String[] items;

    private int n = 0;

    /**
     * 头部指针
     */
    private int head = 0;

    /**
     * 尾部指针
     */
    private int tail = 0;


    public ArrayQueue(int n) {
        this.n = n;
        items = new String[n];
    }

    /**
     * 入队列
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public boolean enqueueUpdate(String item) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            /**
             * 进行数据前移
             */
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
