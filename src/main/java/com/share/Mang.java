package com.share;

import java.lang.management.*;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Mang
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-25 22:02
 **/
public class Mang {
    public static void main(String[] args) {
        // 1. 操作系统信息
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(operatingSystemMXBean.getName());
        // 2. 运行时
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getUptime());
        // 3.1 JVM内存信息
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println(memoryMXBean.getHeapMemoryUsage());
        // 3.2 JVM内存池-列表
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        memoryPoolMXBeans.forEach(s->{
            System.out.println(s.getPeakUsage());
        });
        // 3.3 内存管理器-列表
        List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
        memoryManagerMXBeans.forEach(s->{
            System.out.println(s.getMemoryPoolNames().toString());
        });
        // 4. class加载统计信息
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println(classLoadingMXBean.getLoadedClassCount());
        // 5. 编译统计信息
        CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
        System.out.println(compilationMXBean.getName());
        // 6. 线程
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.println(Arrays.asList(threadMXBean.getAllThreadIds()));
        // 7.GC
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorMXBeans.forEach(s->{
            System.out.println(Arrays.asList(s.getMemoryPoolNames()));
        });
    }
}
