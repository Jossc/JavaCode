package com.thread.demo;

import java.util.LinkedList;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName BlockingQueueForWaitAndNotify.java
 * @createTime 2020年07月21日 22:30:00
 */
public class BlockingQueueForWaitAndNotify {

    private int maxSize = 16;

    private LinkedList<String> linkedList;

    public BlockingQueueForWaitAndNotify(int maxSize, LinkedList<String> linkedList) {
        this.maxSize = maxSize;
        this.linkedList = linkedList;
    }

    public static void main(String[] args) {

    }

    public synchronized void putValue(String value) throws Exception {
        while (linkedList.size() == maxSize) {
            wait();
        }
        linkedList.add(value);
        notifyAll();
    }

    public synchronized String getValue() throws Exception {
        while (linkedList.size() == 0) {
            wait();
        }
        String value = linkedList.remove();
        notifyAll();
        return value;
    }
}
