package com.basics.enumTest;

/**
 * @ClassName EmuTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class   EmuTest {
    public static void main(String[] args) {
        String s = Test.emmm.valaue;
    }
    enum  Test{
        emmm("这是一个枚举类");
        public String valaue;
        Test(String valaue){
            this.valaue =valaue;
        }
        public String getValaue(){
            return valaue;
        }
    }
}
