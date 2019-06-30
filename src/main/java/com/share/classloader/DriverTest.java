package com.share.classloader;


import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName DriverTest
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-30 14:16
 **/
public class DriverTest {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        //(2)
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }
        //(3)
        System.out.println("current thread contextloader:" + Thread.currentThread().getContextClassLoader());
        //(4)
        System.out.println("ServiceLoader loader:" + ServiceLoader.class.getClassLoader());
    }
}
