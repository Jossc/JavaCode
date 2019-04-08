package com.sun.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName RewriteClassLoader
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class RewriteClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream inputStream =
                getClass().getResourceAsStream(fileName);
        if (inputStream == null) {
            try {
                return super.loadClass(name);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

}
