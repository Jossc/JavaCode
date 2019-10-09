package com.cz.agent;

import java.lang.instrument.Instrumentation;

/**
 * @ClassName com.cz.AgentMain
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-09-04 22:17
 **/
public class AgentMain {

    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("agentmain called: " + agentArgs);
        /**
         * 传入什么就返回什么
         * 不修改class 二进制文件
         */
        inst.addTransformer((loader, className, classBeingRedefined,
                             protectionDomain, classfileBuffer) -> {
            System.out.println("agentmain load Class  :" + className);
            return classfileBuffer;
        },true);
    }
}
