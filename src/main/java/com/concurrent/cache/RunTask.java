package com.concurrent.cache;

import sun.util.resources.ga.LocaleNames_ga;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName RunTask
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/9 9:08 下午
 **/
public class RunTask<T> extends RecursiveTask<T> {

    private long start;

    private long end;

    private static final long THRESHOLD = 2;

    public RunTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected T compute() {
        long threshold = start - end;
        Long sum = 0L;
        if (threshold < THRESHOLD) {
            for (long l = start; l < end; l++) {
                sum = sum + 1;
            }
            return (T) sum;
        }
        return null;
    }


}
