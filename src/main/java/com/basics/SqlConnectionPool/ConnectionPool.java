package com.basics.SqlConnectionPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @ClassName ConnectionPool
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/10 10:13
 * @Version 1.0
 **/
public class ConnectionPool {
    private LinkedList<Connection> linkedList  =new LinkedList<Connection>();

    public ConnectionPool(int initialSize){
        if(initialSize>0){
            for(int i =0;i<initialSize;i++){
                linkedList.addLast(ConnectionDriver.createConnection());
            }
        }
    }
    public void releaseConnection(Connection connection){
        if (connection != null) {
            synchronized (linkedList) {
                // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                //这里不用lock 释放当前锁 随机唤醒一个就OK了。直接返回给线程池就好了
                linkedList.addLast(connection);
                linkedList.notifyAll();
            /*    linkedList.notify();*/
            }
        }
    }
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (linkedList) {
            // 完全超时
            if (mills <= 0) {
                while (linkedList.isEmpty()) {
                    linkedList.wait();
                }
                return linkedList.removeFirst();
            } else {long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (linkedList.isEmpty() && remaining > 0) {
                    linkedList.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!linkedList.isEmpty()) {
                    result = linkedList.removeFirst();
                }
                return result;
            }
        }
    }
}
