package com.cz.agent;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.ProtectionDomain;

/**
 * @ClassName AgentPreMain
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-09-04 22:20
 **/
public class AgentPreMain {

    public static class ClassLoggerTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.println("transform: " + className);
            Path path = Paths.get("/tmp/" + className.replaceAll("/", ".") + ".class");
            try {
                Files.write(path, classfileBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return classfileBuffer;
        }
    }

    public static void premain(String agentArgument, Instrumentation instrumentation) {
        ClassFileTransformer classFileTransformer = new ClassLoggerTransformer();
        instrumentation.addTransformer(classFileTransformer, true);
    }
}
