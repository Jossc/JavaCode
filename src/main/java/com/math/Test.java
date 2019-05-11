package com.math;

import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.regression.ModelSpecificationException;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * PACKAGE_NAME: com.math
 * MONTH_NAME_SHORT: 一月
 * USER: Clement
 **/
public class Test extends SimpleRegression {
    public double sumYY;
    public Test(){
        super();
    }

    public Test(double sumYY) {
        this.sumYY = sumYY;
    }

    public Test(boolean includeIntercept, double sumYY) {
        super(includeIntercept);
        this.sumYY = sumYY;
    }

    public double getSumYY() {
        return sumYY;
    }


}
