package com.basics.ThreadCode.cacheTest;

/**
 * @PACKAGE_NAME: com.basics.ThreadCode.cacheTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/23
 * @author: Jossc
 */
public class TestForContent {
    static  final int Line_Num = 1024;
    static  final int Colum_Num = 1024;

    /**
     * cache time : 2
     * @param args
     */
    public static void main(String []args){
        long[][] array = new long[Line_Num][Colum_Num];
        long startTime = System.currentTimeMillis();
        for(int i= 0; i < Line_Num;i++){
            for (int j=0;j<Colum_Num;++j){
                array[i][j] = i *2+j;
            }
        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time : " + cacheTime);

    }
}
