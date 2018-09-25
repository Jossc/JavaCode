package com.basics.ClassLoaderTest.classPathTest;

import java.io.*;

/**
 * PACKAGE_NAME: com.basics.ClassLoaderTest.classPathTest
 * MONTH_NAME_SHORT: 九月
 * USER: Clement
 **/
public class ClassLoaderTest  extends  ClassLoader{
    private String rootDir;
    public ClassLoaderTest(String rootDir){
        this.rootDir = rootDir;
    }

    /**
     * 重写finaClass
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if(null == classData){
            throw  new ClassNotFoundException();
        }else {
            return  defineClass(name,classData,0,classData.length);
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    /**
     * 读取文件字节
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {

        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private  String classNameToPath(String className){
         return  rootDir +File.separatorChar + className.replace('.',File.separatorChar)
                 +".class";
    }

    public static void main(String[] args) {
        String dir = "/Users/mac/Desktop/JavaCode/src/main/java/";
        ClassLoaderTest classLoaderTest
                 = new ClassLoaderTest(dir);
        try {
            Class<?> c
                     = classLoaderTest.loadClass("com.basics.ClassLoaderTest.classPathTest.ObjectHello");
            System.out.println("c :" +c.newInstance().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
