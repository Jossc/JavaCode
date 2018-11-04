package com.basics.SqlConnectionPool;

/**
 * @ClassName tt
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/11 18:10
 * @Version 1.0
 **/
public class tt {
    public synchronized void c(){

    }
    public synchronized void b(){

    }

    public static void main(String[] args) {
        tt t = new tt();
        t.b();
        tt t1 = new tt();
        t1.c();
    }
}
