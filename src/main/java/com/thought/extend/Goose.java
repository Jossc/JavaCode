package com.thought.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Goose
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class Goose extends Bird {
    private static final Logger log = LoggerFactory.getLogger(Goose.class);
    @Override
    public void move() {
        System.out.println("run goose");
    }
}
