package com.cjx;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    public static void main(String[] args) {

        //一
//        MyThread myThread = new MyThread("mythread2");
////        myThread.setName("mythread");
//        myThread.start();
//        Thread.currentThread().setName("主线程");
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        for (int i = 0; i < 50; i++) {
//            if (i % 1 == 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }

//        for (int i = 0; i < 100; i++) {
//            if( i % 2 != 0){
//                System.out.println(i+Thread.currentThread().getName());
//            }
//        }

        //二

        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread2);
        thread.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");
        thread.start();
        thread2.start();
        thread3.start();
    }
}

//创建多线程的第一种方法
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) {
                System.out.println("yield:" + i);
                yield();
            }
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public MyThread() {
    }

    public MyThread(String a) {
        super(a);
    }

}

//创建多线程第二种
class MyThread2 implements Runnable {
    private int ticket = 50;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {

            //synchronized(this) 方式一{
            //类也是一个对象  Class MyThread2 = new MyThread2
            //synchronized(MyThread2.class) 方式二{
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(ticket + " " + Thread.currentThread().getName());
//                    ticket--;
//                } else {
//                    break;
//                }
            //}

            //方式三
            //show();

            //方式四
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticket + " " + Thread.currentThread().getName());
                    ticket--;
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public synchronized void show() {

        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ticket + " " + Thread.currentThread().getName());
            ticket--;
        }
    }
}