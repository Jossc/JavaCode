package com.basics.ThreadCode.ThreadDemo;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName MainThread
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/9 14:47
 * @Version 1.0
 * [6] Monitor Ctrl-Break
 * [5] Attach Listener
 * [4] Signal Dispatcher // 分发处理发送给JVM信号的线程
 * [3] Finalizer //调用 finalizer
 * [2] Reference Handler // 清除Reference的线程
 * [1] main 函数启动入口
 **/
public class MainThread {
    public static void main(String[] args) {
        //获取线程管理
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for(ThreadInfo threadInfo :threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());
        }
    }
}
