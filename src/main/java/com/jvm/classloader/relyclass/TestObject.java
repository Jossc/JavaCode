package com.jvm.classloader.relyclass;

/**
 * @ClassName TestObject
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-26 22:56
 **/
public class TestObject {
    private TestObject testObject;

    public void setTestObject(Object testObject) {
        System.out.println(testObject);
        this.testObject = (TestObject) testObject;
    }
}
