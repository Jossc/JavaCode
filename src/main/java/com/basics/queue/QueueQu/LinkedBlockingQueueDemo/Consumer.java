package com.basics.queue.QueueQu.LinkedBlockingQueueDemo;

import com.basics.queue.utils.User;

/**
 * @PACKAGE_NAME: com.basics.queue.QueueQu.LinkedBlockingQueueDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/10
 * @author: chenzhuo
 */
public class Consumer implements Runnable {

    private User user;
    private PersonPut personPut;

    public Consumer(User user, PersonPut personPut) {
        this.user = user;
        this.personPut = personPut;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("消费者准备消费：" );
                System.out.println(personPut.consume());
                System.out.println("!消费者消费完毕：" + user.getUserName());
                // 休眠1000ms
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Consumer Interrupted");
        }
    }
}
