package com.basics.dynamicAgecy;

import com.basics.agency.PerformanceMonior;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @PACKAGE_NAME: com.basics.dynamicAgecy
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerformanceMonior.begin(o.getClass().getName()+"."+method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        PerformanceMonior.end();
        Object proxyObject =  getProxy(this.getClass());
        return result;
    }
}
