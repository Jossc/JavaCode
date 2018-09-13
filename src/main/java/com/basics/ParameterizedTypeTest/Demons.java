package com.basics.ParameterizedTypeTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * PACKAGE_NAME: com.basics.ParameterizedTypeTest
 * MONTH_NAME_SHORT: 五月
 * USER: Clement
 **/
public class Demons {
    public static void main(String []args){
     //   classTest();
        interfaceTest();
    }
    public static void classTest(){
        MySupperClsss mySupperClsss = new MySupperClsss() {
            @Override
            public void onTest(Object data) {

            }
        };
        ParameterizedType type
                = (ParameterizedType) mySupperClsss.getClass().getGenericSuperclass();
        syType(type);
    }
    public static  void interfaceTest(){
        MyInterface<Student,String> myInterface
                 = new MyInterface<Student, String>() {
            @Override
            public void onSuccess(Student data) {

            }
        };
        ParameterizedType type = (ParameterizedType)
                myInterface.getClass().getGenericInterfaces()[0];
        syType(type);
    }

    /**
     * 返回次类型的实际类型参数Type
     * @param type
     */
    public static  void syType(ParameterizedType type){
        System.out.println(type + "\n" + type.getClass());
        Type[] targets = type.getActualTypeArguments();
        for (int i = 0; i < targets.length; i++) {
            System.out.println(targets[i] + "\n" + targets[i].getClass());
        }

    }
}
