package com.jichu.多线程;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Run3 run3 = new Run3();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.getClass());
        ThreadPoolExecutor server2 = (ThreadPoolExecutor) executorService;
//       设置线程池属性
//        server2.setCorePoolSize(15);
//        server2.setKeepAliveTime();
        //适用于runnable
        executorService.execute(run3);
        //适用于callable
        executorService.submit(run3);
        executorService.shutdown();

    }

}
class Run3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}