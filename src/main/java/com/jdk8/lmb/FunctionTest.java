package com.jdk8.lmb;

import com.jdk8.lmb.model.Point;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Despacito
 * @Author chenzhuo
 * @Version 1.0
 **/
public class FunctionTest {

    public static void main(String[] args) {
        Function<Point,Double> pointDoubleFunction = point -> Double.valueOf(point.hashCode());


        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
  /*      final int sum =0;
        list.forEach(integer ->{}
                int sum=0;
                sum=sum+integer});
*/
    //sum
   /*   list.stream().mapToInt(Integer::intValue).sum();

      list.forEach(FunctionTest::getInteger);*/

        Map<String,String> map =new HashMap<>();
        map.put("alpha","X");
        map.put("bravo","Y");
        map.put("charlie","Z");

        String s = "alpha-bravo-charlie";
        map.replaceAll(s::replace);
        map.replaceAll((s1, s2) -> s1.replaceAll(s1, s2));
        System.out.println(map);

    }

    private static void getInteger(Integer integer) {
    }




}
