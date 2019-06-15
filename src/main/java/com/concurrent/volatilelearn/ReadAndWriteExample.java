package com.concurrent.volatilelearn;

/**
 * @ClassName ReadAndWriteExample
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-05-12 22:34
 **/
public class ReadAndWriteExample {

    private int i;
    private boolean tag = false;

    public static void main(String[] args) {
        new ReadAndWriteExample().test();
    }
    public boolean test(){
        for(int i=0;i<100;i++){
            if(i == 10){
                return false;
            }
        }
        return true;
    }

    public void read() {
        //1
        int i = 1;
        //2
        tag = true;
    }

    public void write() {
        //3
        while (tag) {
            //4
            i = 100;
        }
    }
}
