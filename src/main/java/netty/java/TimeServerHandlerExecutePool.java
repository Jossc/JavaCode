package netty.java;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * @ClassName TimeServerHandlerExecutePool
 * @Description TODO
 * @Author Crazy
 * @Date 2020/6/19 22:39
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executors;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executors = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()
                , maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        executors.execute(task);

    }
}
