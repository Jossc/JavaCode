package com.basics.queue.QueueQu.LinkedBlockingQueueDemo;

import com.basics.queue.utils.User;

/**
 * @PACKAGE_NAME: com.basics.queue.QueueQu.LinkedBlockingQueueDemo
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/10
 * @author: chenzhuo
 * 定义消费者
 */
public class Producer implements Runnable  {
    private User user;
    private PersonPut personPut;

    public Producer(User user, PersonPut personPut) {
        this.user = user;
        this.personPut = personPut;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.err.println("生产者准备生产");
                personPut.produce(user);
                System.err.println("生产者生产完毕"+ user.getUserName());
                Thread.sleep(300);
            }
        }catch (Exception e){

        }
    }
}
