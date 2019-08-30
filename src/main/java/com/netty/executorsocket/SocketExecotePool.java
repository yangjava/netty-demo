package com.netty.executorsocket;


import java.util.concurrent.*;

/**
 * 使用线程池
 */
public class SocketExecotePool {

    private ExecutorService executorService;

    public SocketExecotePool(int maximumPoolSize,int queueSize){
        executorService=new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
        maximumPoolSize,120L,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task){
        executorService.execute(task);
    }

}
