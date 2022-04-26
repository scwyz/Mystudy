package com.cjx;

public class ThreadTest {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread("mythread2");
////        myThread.setName("mythread");
//        myThread.start();
//        Thread.currentThread().setName("主线程");
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }

//        for (int i = 0; i < 100; i++) {
//            if( i % 2 != 0){
//                System.out.println(i+Thread.currentThread().getName());
//            }
//        }
    MyThread2 myThread2 = new MyThread2();
    Thread thread = new Thread(myThread2);
    Thread thread2 = new Thread(myThread2);
    Thread thread3 = new Thread(myThread2);
    thread.start();
    thread2.start();
    thread3.start();

    }
}
//创建多线程的第一种方法
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 20 == 0) {
                yield();
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
class MyThread2 implements Runnable{
    int ticket = 100;
    @Override
    public void run() {
        while( true ){
            if(ticket>0){
                System.out.print(ticket--+" ");
            }else {
                break;
            }
        }
    }
}
