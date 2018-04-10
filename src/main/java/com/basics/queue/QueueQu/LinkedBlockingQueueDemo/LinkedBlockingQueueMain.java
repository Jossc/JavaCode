package com.basics.queue.QueueQu.LinkedBlockingQueueDemo;

import com.basics.queue.utils.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.basics.queue.QueueQu.LinkedBlockingQueueDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/10
 * @author: chenzhuo
 * 测试 主方法
 */
public class LinkedBlockingQueueMain {

    public static void main(String []args) throws InterruptedException {
        User user = new User("chenzhuo ",1) ;
        PersonPut personPut = new PersonPut();
        ExecutorService service = Executors.newCachedThreadPool();
        Producer p1 = new Producer(user,personPut);
        Producer p2 = new Producer(user,personPut);

        Consumer consumer = new Consumer(user, personPut);
        service.submit(p1);
        service.submit(p2);
        service.submit(consumer);


        //5秒后关闭
        Thread.sleep(5000);
        service.shutdownNow();

    }
}
