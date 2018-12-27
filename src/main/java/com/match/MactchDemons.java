package com.match;

import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * @ClassName MactchDemons
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class MactchDemons {
    public static void main(String[] args) {
       /* SimpleRegression simpleRegression  = new SimpleRegression(true);
        simpleRegression.addData(4.5,5.8);
        simpleRegression.addData(4100,5.8);
        simpleRegression.addData(2.5,6.8);
        System.out.println(simpleRegression.getRSquare());
        System.out.println(simpleRegression. getSlopeStdErr());*/

       /* double[][] data = { { 54, 61 }, { 66, 80 }, { 68, 62 }, { 76, 86 }, { 78, 84 },
                { 82, 76 }, { 85, 85 }, { 87, 82 }, { 90, 88 }, { 94, 82 }, { 90, 88 },
                { 94, 96 } };
       */

        SimpleRegression regression = new SimpleRegression();
        regression.addData(1,88.66);// 增加要分析的数据
        regression.addData(2,0);
        regression.addData(3,0);
        regression.addData(4,97.33);
        regression.addData(5,90.66);
        regression.addData(6,83.25);
        regression.addData(7,90.25);
        regression.addData(8,87);
        regression.addData(9,86.33);
        regression.addData(10,0);
        regression.addData(12,91.5);
        regression.addData(13,90);
        regression.addData(14,0);
        regression.addData(15,83);
        regression.addData(16,85);
        regression.addData(17,0);
        regression.addData(18,0);
        regression.addData(19,85);
        regression.addData(20,85);
        regression.addData(21,85);
        regression.addData(22,83.66);
        regression.addData(23,79);
        regression.addData(24,84.5);
        regression.addData(25,0);
        regression.addData(26,77);
        regression.addData(27,81.5);
        regression.addData(28,82.5);
        regression.addData(29,85.66);
        regression.addData(30,78.5);
        regression.addData(31,81);
        regression.addData(32,84.5);
        regression.addData(33,83);
        regression.addData(34,87.5);
        regression.addData(35,85);
        regression.addData(36,85.5);
        regression.addData(37,82.5);
        regression.addData(38,81.5);
        regression.addData(39,84);
        regression.addData(40,80.5);
        regression.addData(41,84.66);
        regression.addData(42,84.14);
        regression.addData(43,80.66);
        regression.addData(44,85.33);
        regression.addData(45,90.92);
        regression.addData(46,86.75);
        regression.addData(47,85.8);
        regression.addData(48,92);
        regression.addData(49,89);
        regression.addData(50,89.46);
        regression.addData(51,87.5);
        regression.addData(52,88.25);
        regression.addData(53,86);
        regression.addData(54,89.42);

        System.out.println("斜率是：" + regression.getSlope());
        System.out.println("斜率标准差是：" + regression.getSlopeStdErr());
        System.out.println("截距是：" + regression.getIntercept());
        System.out.println("标准差是：" + regression.getInterceptStdErr());
        System.out.println("误差平方和是：" + regression.getSumSquaredErrors());
        System.out.println("相关系数R方：" + regression.getRSquare());
        System.out.println("相关系数r：" + regression.getR());
        System.out.println("回斜率(equiv)相关性的显著性水平。：" + regression.getSignificance());


        SimpleRegression regression1 = new SimpleRegression();
        regression1.addData(1,136);// 增加要分析的数据
        regression1.addData(4,139.33);
        regression1.addData(5,143.33);
        regression1.addData(6,129.5);
        regression1.addData(7,133.5);
        regression1.addData(8,135);
        regression1.addData(9,134.66);
        regression1.addData(12,140.5);
        regression1.addData(13,143);
        regression1.addData(15,130);
        regression1.addData(16,134);
        regression1.addData(19,118);
        regression1.addData(20,137);
        regression1.addData(21,135);
        regression1.addData(22,132);
        regression1.addData(23,127);
        regression1.addData(24,137);
        regression1.addData(26,120);
        regression1.addData(27,126.5);
        regression1.addData(28,121.5);
        regression1.addData(29,127.66);
        regression1.addData(30,121);
        regression1.addData(31,119);
        regression1.addData(32,127.5);
        regression1.addData(33,117);
        regression1.addData(34,132);
        regression1.addData(35,121);
        regression1.addData(36,127.5);
        regression1.addData(37,125.75);
        regression1.addData(38,128.25);
        regression1.addData(39,123);
        regression1.addData(40,128.25);
        regression1.addData(41,131);
        regression1.addData(42,127.28);
        regression1.addData(43,120);
        regression1.addData(44,128.66);
        regression1.addData(45,140.64);
        regression1.addData(46,133.875);
        regression1.addData(47,129.4);
        regression1.addData(48,138.11);
        regression1.addData(49,132.7);
        regression1.addData(50,140.53);
        regression1.addData(51,138.33);
        regression1.addData(52,140.25);
        regression1.addData(53,133);
        regression1.addData(54,136.71);


        System.out.println("斜率标准差是1：" + regression1.getSlopeStdErr());
        System.out.println("截距是1：" + regression1.getIntercept());
        System.out.println("标准差是1：" + regression1.getInterceptStdErr());
        System.out.println("误差平方和是1：" + regression1.getSumSquaredErrors());
        System.out.println("相关系数R方1：" + regression1.getRSquare());
        System.out.println("相关系数r1:" + regression1.getR());
        System.out.println("回斜率(equiv)相关性的显著性水平1:" + regression1.getSignificance());

    }
}
