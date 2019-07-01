package com.jvm.classloader.classloader;

import java.io.*;

/**
 * @ClassName classloadertest
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-06-22 16:14
 **/
public class ClassLoaderTest extends ClassLoader {

    private String className;
    private final String fileExtension = ".class";
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    ClassLoaderTest(String className) {
        super();
        this.className = className;
    }

    public ClassLoaderTest(ClassLoader parent, String className) {
        super(parent);
        this.className = className;
    }

    public static void main(String[] args) throws Exception {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest("loader");
        //classLoaderTest.setPath("/Users/demons/IdeaProjects/JavaCode/target/classes/com/jvm/classloader/relyclass/");
        classLoaderTest.setPath("/Users/mac/Desktop/");
        Class aClass = classLoaderTest.loadClass("com.jvm.classloader.relyclass.TestOne");
        aClass.newInstance();

    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.jvm.classloader.relyclass.TestOne");
        Object object = clazz.newInstance();
        System.out.println(object.getClass().getName());

    }

    @Override
    protected Class<?> findClass(String name) {
        System.out.println("find Class :" + name);
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }

    @Override
    public String toString() {
        return "classloadertest{" +
                "className='" + className + '\'' +
                '}';
    }

    private byte[] loadClassData(String name) {
        System.out.println("name:" + name);
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            name = name.replace(".", "/");
            String filePath = path + name + fileExtension;
            System.out.println("filePath :" + filePath);
            is = new FileInputStream(new File(path + name + fileExtension));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                byteArrayOutputStream.write(ch);
            }
            data = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
}
