package com.basics.queue.QueueQu.LinkedBlockingQueueDemo;

import com.basics.queue.utils.User;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @PACKAGE_NAME: com.basics.queue.QueueQu.LinkedBlockingQueueDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/10
 * @author: chenzhuo
 */
public class PersonPut {

    ///定义3个长度
    BlockingQueue<User> basket = new LinkedBlockingQueue<User>(3);


    /**
     * 存放一个
     * @throws InterruptedException
     */
    public void produce() throws InterruptedException {
        User user = new User("chenzhuo",1);
        basket.put(user);
    }

    /**
     * 消费一个
     * @return
     * @throws InterruptedException
     */
    public User consume() throws InterruptedException {

        return basket.take();
    }


}
