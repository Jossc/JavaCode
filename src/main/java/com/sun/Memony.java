package com.sun;

/**
 * @ClassName Memony
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/21 18:27
 * @Version 1.0
 **/
public class Memony {

    public static void main(String[] args) throws InterruptedException {
        for (int i =0;i<128;i++){
            if(i<70){
                byte[] b = new byte[1*1024*1024];
            }
            if(i==72){
                System.err.println("使用了 72m");
                Thread.sleep(2000);
            }
            byte[]b1 = new byte[1*1024*1024];
        }
        System.err.println("end ---- ");
    }
}
