package com.math;

import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * PACKAGE_NAME: com.math
 * MONTH_NAME_SHORT: 十二月
 * USER: Clement
 **/
public class MacthDemo {
    public static void main(String[] args) {
      /*  SimpleRegression simpleRegression
                 = new SimpleRegression();
        simpleRegression.addData(4.5,5.7);
        System.out.println(simpleRegression.getN());
        simpleRegression.addData(4.6,6.8);
        System.out.println(simpleRegression.getN());
        simpleRegression.addData(4.9,3.4);
        System.out.println(simpleRegression.getN());
        simpleRegression.addData(500,500);
        simpleRegression. getSlopeConfidenceInterval();
       // System.out.println("SlopeConfidenceInterval:" +    simpleRegression. getSlopeConfidenceInterval());
        System.out.println("SlopeConfidenceInterval:" +    simpleRegression. getSignificance());*/


        double[][] user1Low= {{1,55},{2,55},
                {3,73},{4,72.5},{5,60},
                {14,81.8},{17,60.57},
                {18,55},{19,54},{20,57},{21,60},{22,51.71},
                {23,56},{24,59.14},{25,59.14},{26,57.33},
                {27,54},{28,55.5},{29,55},{30,53},{31,60.57},{32,59.5},
                {33,54},{35,60},{36,54},{37,55.75},{38,51},
                {39,50.75},{39,53.5},{40,55.2},{41,53.75},
                {42,54},{43,54},{44,54.4},{45,48,},{47,51.83},
                {48,53.66},{49,57.54},{50,56},{52,63.75},{53,56,75},{54,56},
                {55,58},{56,54.8}};

        double[][] user1High= {{1,144.5},{2,132.5},
                {3,119},{4,120},{5,136},
                {14,142.6},{17,135.28},
                {18,128},{19,121},{20,124},{21,123},{22,113.14},
                {23,119.5},{24,123.42},{25,125.85},{26,129.88},
                {27,121.5},{28,122.25},{29,114.25},{30,118},{31,123.85},{32,131},
                {33,121},{35,125},{36,121},{37,118.875},{38,113},
                {39,120.75},{39,123.5},{40,127.6},{41,118.62},
                {42,123.2},{43,124},{44,114},{45,117},{47,120.66},
                {48,123},{49,131.54},{50,129},{52,139.5},{53,129},{54,127.66},
                {55,131},{56,125.8}};

        double[][] user2Low= {{1,75.66},{2,74.25},
                {3,77},{4,68.57},{5,79.5},
                {6,83},{8,83},
                {9,80},{10,82},{11,82},{12,81},{13,83},
                {14,82},{15,79},{16,72.5},{30,80}};
        double[][] user2H= {{1,119},{2,120},
                {3,120.5},{4,109.57},{5,126.5},
                {6,117},{8,123},
                {9,121.5},{10,132.5},{11,123},{12,125.5},{13,134},
                {14,132.5},{15,123.5},{16,120},{30,125.75}};
        SimpleRegression regression = new SimpleRegression();
        regression.addData(user2H);
        System.out.println("斜率是：" + regression.getSlope());
        System.out.println("斜率标准差是：" + regression.getSlopeStdErr());
        System.out.println("截距是：" + regression.getIntercept());
        System.out.println("标准差是：" + regression.getInterceptStdErr());
        System.out.println("误差平方和是：" + regression.getSumSquaredErrors());
        System.out.println("相关系数R方：" + regression.getRSquare());
        System.out.println("相关系数r：" + regression.getR());
        System.out.println("回斜率(equiv)相关性的显著性水平。：" + regression.getSignificance());
    }
}
