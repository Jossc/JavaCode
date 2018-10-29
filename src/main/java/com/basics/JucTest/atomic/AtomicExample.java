package com.basics.JucTest.atomic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * PACKAGE_NAME: com.basics.JucTest.atomic
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class AtomicExample {
    final AtomicLong atomic1 = new AtomicLong(0);
    final AtomicLong atomic2 = new AtomicLong(0);
    final AtomicLong atomic3 = new AtomicLong(0);
    final AtomicLong atomic4 = new AtomicLong(0);
    final AtomicLong atomic5 = new AtomicLong(0);
    final AtomicLong atomic6 = new AtomicLong(0);
    final AtomicLong atomic7 = new AtomicLong(0);
    final AtomicLong atomic8 = new AtomicLong(0);
    final AtomicLong atomic9 = new AtomicLong(0);
    final AtomicLong atomic10 = new AtomicLong(0);
    final AtomicReference atomic11 = new AtomicReference<String>("String");
    final AtomicReference atomic12 = new AtomicReference<String>("String");
    final AtomicReference atomic13 = new AtomicReference<String>("String");
    final AtomicReference atomic14 = new AtomicReference<String>("String");
    final AtomicReference atomic15 = new AtomicReference<String>("String");
    final AtomicReference atomic16 = new AtomicReference<String>("String");
    final AtomicReference atomic17 = new AtomicReference<String>("String");
    final AtomicReference atomic18 = new AtomicReference<String>("String");
    final AtomicReference atomic19 = new AtomicReference<String>("String");
    final AtomicReference atomic20 = new AtomicReference<String>("String");


    public static void main(String[] args) throws Exception {
        List<AtomicExample> list = new LinkedList<AtomicExample>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new AtomicExample());
        }
        System.out.println("Created instances 1000000");

        System.in.read();
    }
}


