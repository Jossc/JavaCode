package com.jdk8.base;


import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Hikari
 * @version 1.0.0
 * @ClassName FunctionApple.java
 * @createTime 2020年12月05日 17:44:00
 */
public class FunctionApple {


    public static void main(String[] args) {
        List<Apple> req = Arrays.asList(new Apple("red", 100),
                new Apple("red", 150),
                new Apple("green", 100));

        List<Apple> apples = filterApple(req, FunctionApple::isGreen);

        Predicate<Apple> predicate = s -> apples.add(new Apple("1", 2));
        System.out.println(predicate.test(new Apple("1", 2)));

        /*   Function<String, Integer> integerFunction = (String s) -> Integer.parseInt(s);*/
        Function<String, Integer> integerFunction = Integer::parseInt;
        System.out.println(integerFunction.apply("2"));
        Function<String, Apple> createApple = Apple::new;
        System.out.println(createApple.apply("黄色").toString());
        BiFunction<String, Integer, Apple> biFunction = Apple::new;
        System.out.println(biFunction.apply("黄色", 200).toString());

    }


    private static boolean isGreen(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        list.forEach(apple -> {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        });
        return result;
    }


}
