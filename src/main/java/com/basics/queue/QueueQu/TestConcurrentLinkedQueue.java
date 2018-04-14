package com.basics.queue.QueueQu;

import com.basics.queue.utils.User;

import java.util.concurrent.*;

/**
 * @PACKAGE_NAME: com.basics.queue.QueueQu
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/10
 * @author: chenzhuo
 * 无界非阻塞队列ConcurrentLinkedQueue
 */
public class TestConcurrentLinkedQueue {

    private static ConcurrentLinkedDeque<User> concurrentLinkedDeque
            = new ConcurrentLinkedDeque<User>();

    private static ExecutorService executorService = Executors.newScheduledThreadPool(3);


    public static void main(String []args){

        User user = new User("124",11);
        User user1 = new User("234",123);
        User user2 = new User("44",22);
        User user3 = new User("55",11);

    /*    concurrentLinkedDeque.add(user);
        concurrentLinkedDeque.addLast(user1);
        concurrentLinkedDeque.add(user1);
        concurrentLinkedDeque.add(user2);
        concurrentLinkedDeque.add(user3);

        concurrentLinkedDeque.forEach(u->
        System.err.println("username :"
            + u.getUserName())
        );*/
/*
        ll:
        for(int i=0;i<100;i++){
            if(i==1){
                System.err.println(i +" :i");
                break ll;
            }
        }
*/

        executorService.submit(()->{
            concurrentLinkedDeque.add(user);
            concurrentLinkedDeque.add(user1);
            concurrentLinkedDeque.add(user2);
            concurrentLinkedDeque.add(user3);
        });

   /*     executorService.submit(()->{
            concurrentLinkedDeque.remove(user);
            concurrentLinkedDeque.add(user1);
            concurrentLinkedDeque.add(user2);
            concurrentLinkedDeque.add(user3);
        });
*/
        System.err.println("size : " + concurrentLinkedDeque.size());
        concurrentLinkedDeque.forEach(u->
                System.err.println("username :"
                        + u.getUserName())
        );

        executorService.shutdownNow();




    }

}
