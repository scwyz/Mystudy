package com.jichu.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用callable新建线程
 */
public class ThreadJdk5 {
    public static void main(String[] args) {
        Threadcllable threadcllable= new Threadcllable();
        FutureTask futureTask = new FutureTask(threadcllable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class Threadcllable implements Callable {
    @Override
    public Object call() throws Exception {
        int a = 0;
        for (int i = 0; i < 100 ; i++) {
            a += i;
        }
        return a;
    }
}