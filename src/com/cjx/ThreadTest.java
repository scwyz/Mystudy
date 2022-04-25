package com.cjx;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("mythread2");
//        myThread.setName("mythread");
        myThread.start();

//        for (int i = 0; i < 100; i++) {
//            if( i % 2 != 0){
//                System.out.println(i+Thread.currentThread().getName());
//            }
//        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if( i % 2 == 0){
                System.out.println(i+Thread.currentThread().getName());
            }
        }
    }
    public MyThread(){
    }
    public MyThread(String a){
        super(a);
    }
}
