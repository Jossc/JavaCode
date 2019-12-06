package com.jdk8.invokedynamic;

import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.*;

/**
 * @ClassName Circuit
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/2 10:36 下午
 **/
public class Circuit {
    public static void startRace(Object obj) {
   /*     Lookup  lookup =new Lookup(obj.getClass());
        boosStrap();*/
    }

    public static void main(String[] args) {
        startRace(new Horse());
    }

    public static CallSite boosStrap(Lookup l, String name, MethodType callSiteTyp) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle mh = l.findVirtual(Horse.class, name, MethodType.methodType(void.class));
        return  new ConstantCallSite(mh.asType(callSiteTyp));

    }


}
