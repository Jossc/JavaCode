package com.sun.jvm.Jvm;

/**
 * @ClassName TestStackDeep
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TestStackDeep {
   private static int count = 0;
   public static void recursion(long a,long b,long c){
       long e1=1,f=2,g=3,h=4,i=5,k=6;
       count++;
       recursion(a, b, c);
   }
   public static  void recursion(){
       count++;
       recursion();
   }

    public static void main(String[] args) {
       try {
           recursion(0L,0L,0L);
       }catch (Exception e){
           System.out.println("deep of calling = " + count);
           e.printStackTrace();
       }
    }
}
