package com.longRange;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * @ClassName CompletionServiceTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class CompletionServiceTest {

    public static void main(String[] args) {
        int taskSize = 5;
        ExecutorService executor = Executors.newFixedThreadPool(taskSize);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
        for (int i = 1; i <= taskSize; i++) {
            int sleep = taskSize - i; // 睡眠时间
            int value = i; // 返回结果
            // 向线程池提交任务
        }

        Consumer consumer;
    }
}
