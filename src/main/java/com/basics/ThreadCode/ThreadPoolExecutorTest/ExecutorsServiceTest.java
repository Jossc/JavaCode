package com.basics.ThreadCode.ThreadPoolExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.ThreadPoolExecutorTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/17
 * @author: chenzhuo
 */
public class ExecutorsServiceTest {

    private static ExecutorService executorService
             = Executors.newFixedThreadPool(10);

    public static void main(String []args){
        executorService.execute(new Tes());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdownNow();
        }
    }

    public static  class  Tes implements  Runnable{
        volatile  int i;
        @Override
        public void run() {
           for (i= 0;i<100;i++){
                System.out.println("i : " + i );
           }
        }
    }

}
