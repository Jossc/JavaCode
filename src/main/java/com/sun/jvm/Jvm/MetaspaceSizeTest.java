package com.sun.jvm.Jvm;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MetaspaceSizeTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * jdk1.7 -XX:PermSize=64m -XX:MaxPermSize=128m -XX:+PrintGCDetails
 * jdk1.8 -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=64m -XX:+PrintGCDetails
 * java -XX:+PrintFlagsFinal -version 查看java查看所有默认的jvm参数
 *  uintx InitialSurvivorRatio                      = 8                                   {product} 新生代Eden/Survivor空间的初始比例
 *  uintx NewRatio                                  = 2                                   {product} Old区 和 Yong区 的内存比例
 *
 *  -XX:InitialHeapSize=267066944
 *  -XX:MaxHeapSize=4273071104
 *  -XX:+PrintCommandLineFlags
 *  -XX:+UseCompressedClassPointers
 *  -XX:+UseCompressedOops
 *  -XX:-UseLargePagesIndividualAllocation
 *  -XX:+UseParallelGC
 **/
public class MetaspaceSizeTest {

    public static void main(String[] args) {
        int i =0 ;
        try {
           /* for (i = 0; i < 100000; i++) {
                Map<String, Class<?>> propertyMap = new HashMap<>();
                propertyMap.put("test",Class.forName("java.lang.String"));
                CglibBean bean = new CglibBean(propertyMap);
                bean.setVaule("ts","1233");
                String className =  bean.getValue("test").getClass().getName();
                System.out.println("className:" + className);
            }*/
            ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
          /*  while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(MetaspaceSizeTest.class);
                enhancer.setCallbackTypes(new Class[]{Dispatcher.class, MethodInterceptor.class});
                enhancer.setCallbackFilter(new CallbackFilter() {
                    @Override
                    public int accept(Method method) {
                        return 1;
                    }

                    @Override
                    public boolean equals(Object obj) {
                        return super.equals(obj);
                    }
                });
            }*/
            for(i = 0; i < 10; i++){
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(MetaspaceSizeTest.class);
                enhancer.setCallbackTypes(new Class[]{Dispatcher.class, MethodInterceptor.class});
                enhancer.setCallbackFilter(new CallbackFilter() {
                    @Override
                    public int accept(Method method) {
                        return 1;
                    }
                    @Override
                    public boolean equals(Object obj) {
                        return super.equals(obj);
                    }
                });
                Class clazz = enhancer.createClass();
                System.out.println(clazz.getName());
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
           /*     System.out.println("total: " + classLoadingMXBean.getTotalLoadedClassCount());
                System.out.println("active: " + classLoadingMXBean.getLoadedClassCount());
                System.out.println("unloaded: " + classLoadingMXBean.getUnloadedClassCount());*/
            }


        } catch (Exception e){
            System.err.println("count" + i );
        }
    }
}
