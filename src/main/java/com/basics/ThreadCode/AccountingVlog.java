package com.basics.ThreadCode;

/**
 * volatile 不安全实例
 * volatile 只保证了可见行（内存刷新）
 * 并不保证线程安全（原子性）
 */
public class AccountingVlog implements  Runnable {
    static  AccountingVlog accountingVlog = new AccountingVlog();
    static  volatile  int i =0;
    public static  void increase(){
        i ++;
    }

    @Override
    public void run() {
        for(int j =0;j<100000;j++){
            increase();
        }
    }

    /**
     * i: 162672
     * i并不是200000
     * @param args
     * @throws InterruptedException
     */
    public static void main(String []args) throws InterruptedException {
        Thread thread = new Thread(accountingVlog);
        Thread thread1 = new Thread(accountingVlog);
        thread.start(); thread1.start();
        thread.join();thread1.join();
        System.err.println("i: " + i);
    }

}
