package com.jdk8.base;

import lombok.Data;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName Apple.java
 * @createTime 2020年12月05日 17:42:00
 */
@Data
public class Apple {

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color) {
        this.color = color;
    }

    public static boolean isGreen(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
