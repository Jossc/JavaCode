package com.basics.queue.QueueQu;

import com.basics.queue.utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @PACKAGE_NAME: com.basics.queue.QueueQu
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/10
 * @author: chenzhuo
 * LinkedBlockingQueue
 * 由链表实现的有界队列阻塞队列
 */
public class TestLinkedBlockingQueue {
    public static  void main(String [] args){
        test();
    }

    public static void test(){
        //最好初始化给值
        //默认大小为Integer.MAX_VALUE
        LinkedBlockingQueue<User> linkedBlockingQueue = new LinkedBlockingQueue<User>(4);
        User user = new User("张三",11);
        User user1 = new User("张三1",11);
        User user2 = new User("张三2",11);
        User user3 = new User("张三3",11);
        User user4 = new User("张三4",11);
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
       // list.add(user4);
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        linkedBlockingQueue.addAll(list);
        try {
            //移除头元素
            User poll = linkedBlockingQueue.poll(10,TimeUnit.SECONDS);
            System.err.println("user Name : " + poll.getUserName());
            //10秒钟内如果有释放的 就添加成功 true
            // else false
            boolean b = linkedBlockingQueue.offer(user4,10,TimeUnit.SECONDS);
            System.err.println("b : " + b);

            User peek = linkedBlockingQueue.peek();
            System.err.println("usre Name : " + peek.getUserName());

            linkedBlockingQueue.remove(user2); linkedBlockingQueue.add(user1);

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        }
        System.err.println("size : " + linkedBlockingQueue.size());
        linkedBlockingQueue.forEach(l->System.err.println("getName :" + l.getUserName()));

    }

    public static  class  TestLinkedBlockingQueueRun implements Runnable{

        @Override
        public void run() {

        }
    }
}
