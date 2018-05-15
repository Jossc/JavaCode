package com.basics.ThreadCode;

/**
 * PACKAGE_NAME: com.basics.ThreadCode
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 * 可以使用CountDownLatch
 **/
public class ThreadJoin {

    /**
     * wait all child thread over!
         child threadTwo over!
         chid threadOne over
         all child thread over!
        主线程阻塞
     * @param args
     * @throws InterruptedException
     */
    public static void main(String []args) throws InterruptedException {
        Thread threadOne = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("chid threadOne over");
        });
        Thread threadTwo = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child threadTwo over!");
        });
        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");
        //阻塞main 等待1执行完
        threadOne.join();
        //阻塞main 等待2执行完
        threadTwo.join();
        System.out.println("all child thread over!");

    }

}
