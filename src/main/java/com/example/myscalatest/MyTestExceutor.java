package com.example.myscalatest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.*;

public class MyTestExceutor {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("LoadListExecutor-%d").build();
    private static ExecutorService poolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2 + 1, 512, 50, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024) ,namedThreadFactory);

    public MyTestExceutor() {}

    public void out() {
        System.out.println("hhhh");
    }

    public void out2() {
        poolExecutor.submit(()-> System.out.println("sss"));
    }
}
