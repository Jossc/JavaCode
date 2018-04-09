package com.basics.agency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @PACKAGE_NAME: com.basics
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 * 代理类 jdk 静态代理
 */
public class MyInvocationHandler implements InvocationHandler {
    private  Object target;
    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonior.begin(target.getClass().getName()+"."+method.getName());
        System.out.println("-----------------begin "+method.getName()+"-----------------");
     /*   Object result = method.invoke(target, args);
        System.err.println("result Length:"
        + result.getClass().getMethods().length);*/
        System.out.println("-----------------end "+method.getName()+"-----------------");
        PerformanceMonior.end();
        return null;
    }

    /**
     * 返回新的代理
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
