package com.basics.queue.PriorityBlockingQueueQu;

import com.basics.queue.utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @PACKAGE_NAME: com.basics.queue.PriorityBlockingQueueQu
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 */
public class TestPriorityBlockingQueue {

    public static  void main(String []args){
        test();
    }

    public static  void test(){
        PriorityBlockingQueue<User> queue =
                new PriorityBlockingQueue<User>();
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
        list.add(user4);
     /*   queue.add(user);
        queue.put(user);*/
        queue.addAll(list);
        System.err.println("size : " + queue.size());
        queue.forEach(q->{
            System.err.println("userName"+q.getUserName());

        });

    }
}
