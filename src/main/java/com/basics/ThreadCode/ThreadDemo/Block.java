package com.basics.ThreadCode.ThreadDemo;

/**
 * @ClassName Block
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/9 15:41
 * @Version 1.0
 **/
public class Block  implements  Runnable{
    @Override
    public void run() {
      synchronized (Block.class){
          while (true){
              SleepUtils.second(100);
          }
      }
    }
}
