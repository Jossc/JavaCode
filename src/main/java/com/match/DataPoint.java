package com.match;

/**
 * PACKAGE_NAME: com.match
 * MONTH_NAME_SHORT: 十二月
 * USER: Clement
 **/
public class DataPoint {

    public float x;
    public float y;

    public DataPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public DataPoint(){

    }

    public static void main(String[] args) {

        long  i= Long.parseLong("F0FE6BEF44CE", 16);
        //
        //59 264975523155932
        //57 264975523206500   50568
        //65 264975523207656   1156
        //67 264975523202254   264975523202254
        System.out.println("i:" + i );
    }
}
