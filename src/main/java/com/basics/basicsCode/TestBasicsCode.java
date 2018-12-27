package com.basics.basicsCode;

import java.lang.reflect.Field;

/**
 * PACKAGE_NAME: com.basics.basicsCode
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class TestBasicsCode{

    public static void main(String[] args) {
        try {
            //getDeclaredField
            Field field
                    = Class.forName("java.lang.Class").getField("getPrimitiveClass");
            String name = field.getName();
            System.out.println("name : " + name );
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
