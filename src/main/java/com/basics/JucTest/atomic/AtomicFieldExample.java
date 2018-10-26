package com.basics.JucTest.atomic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * PACKAGE_NAME: com.basics.JucTest.atomic
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class AtomicFieldExample {
    volatile long atomic1 = 0;
    volatile long atomic2 = 0;
    volatile long atomic3 = 0;
    volatile long atomic4 = 0;
    volatile long atomic5 = 0;
    volatile long atomic6 = 0;
    volatile long atomic7 = 0;
    volatile long atomic8 = 0;
    volatile long atomic9 = 0;
    volatile long atomic10 = 0;
    volatile String atomic11 = "String";
    volatile String atomic12 = "String";
    volatile String atomic13 = "String";
    volatile String atomic14 = "String";
    volatile String atomic15 = "String";
    volatile String atomic16 = "String";
    volatile String atomic17 = "String";
    volatile String atomic18 = "String";
    volatile String atomic19 = "String";
    volatile String atomic20 = "String";

    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC1_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic1");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC2_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic2");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC3_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic3");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC4_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic4");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC5_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic5");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC6_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic6");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC7_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic7");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC8_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic8");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC9_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic9");
    static final AtomicLongFieldUpdater<AtomicFieldExample> ATOMIC10_UPDATER =
            AtomicLongFieldUpdater.newUpdater(AtomicFieldExample.class, "atomic10");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC11_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic11");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String>ATOMIC12_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic12");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC13_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic13");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC14_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic14");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC15_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic15");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC16_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic16");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String>ATOMIC17_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic17");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC18_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic18");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String> ATOMIC19_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic19");
    static final AtomicReferenceFieldUpdater<AtomicFieldExample, String>ATOMIC20_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(AtomicFieldExample.class, String.class, "atomic20");

    public static void main(String[] args) throws Exception {
        List<AtomicFieldExample> list = new LinkedList <AtomicFieldExample>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new AtomicFieldExample());
        }
        System.out.println("Created instances 1000000");

        System.in.read();
    }
}
