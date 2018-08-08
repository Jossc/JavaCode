package com.basics.JavaassistTest;

import sun.misc.Contended;

/**
 * PACKAGENAME: com.basics.JavaassistTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 八月
 * 1.8缓存行
 *  sun.misc.Contended("tlr")
 * @link @Contended
 **/
public class TestLineDemo {
    @Contended
    String name;

    @Contended
    String value;


}
