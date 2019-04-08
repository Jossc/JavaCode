package com.thought.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Penguin
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class Penguin extends Bird {
    private static final Logger log = LoggerFactory.getLogger(Penguin.class);
    @Override
    public void move() {
        System.out.println("run Penguin");
    }
}
