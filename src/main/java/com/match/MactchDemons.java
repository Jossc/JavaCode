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

        double[][] data = { { 54, 61 }, { 66, 80 }, { 68, 62 }, { 76, 86 }, { 78, 84 },
                { 82, 76 }, { 85, 85 }, { 87, 82 }, { 90, 88 }, { 94, 82 }, { 90, 88 },
                { 94, 96 } };
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);// 增加要分析的数据
        System.out.println("斜率是：" + regression.getSlope());
        System.out.println("斜率标准差是：" + regression.getSlopeStdErr());
        System.out.println("截距是：" + regression.getIntercept());
        System.out.println("截距标准差是：" + regression.getInterceptStdErr());
        System.out.println("误差平方和是：" + regression.getSumSquaredErrors());
        System.out.println("相关系数R方：" + regression.getRSquare());
        System.out.println("相关系数r：" + regression.getR());
        System.out.println("回斜率(equiv)相关性的显著性水平。：" + regression.getSignificance());
    }
}
