package com.sun.jvm.ClassLocader.ClassFileStructure;

import java.util.List;

/**
 * @ClassName TestClass
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TestClass {
    private  int n;
    private int inc(){
        return  n+1;
    }

    public static void main(String[] args) {
        test();

    }
    public static void  test(){
        int i;
        try {
           i =1;
        }catch (Exception e){
            i =2;
        }finally {
            i =3;

        }
    }

    public void test1(List<String> list){
        synchronized (list){

        }
    }

}
