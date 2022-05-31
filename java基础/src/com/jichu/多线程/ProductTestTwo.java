package com.jichu.多线程;

public class ProductTestTwo {
    public static void main(String[] args) {
        Clerk2 c = new Clerk2(0);
        Produce2 p = new Produce2(c);
        Consumer2 co = new Consumer2(c);
        p.setName("生产者");
        co.setName("消费者");
        p.start();
        co.start();
    }
}

class Clerk2{
    private int count;

    public Clerk2(int count) {
        this.count = count;
    }

    public Clerk2() {
    }

    public synchronized void produce(){
        notify();
        if(count<20){
            count++ ;
            System.out.println(Thread.currentThread().getName() + "生产成功 count现有："+count);
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumer(){
        notify();
        if(count >0){
            count--;
        }else {
            System.out.println(Thread.currentThread().getName() + "消费成功 count现有："+count);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Produce2 extends Thread{
    private Clerk2 clerk2;
    public Produce2(Clerk2 clerk2){
        this.clerk2 = clerk2;
    }
    @Override
    public void run() {
        while (true){
            clerk2.produce();
            System.out.println("生产者开始生产");
        }
    }
}

class Consumer2 extends  Thread{
    private Clerk2 clerk2;
    public Consumer2(Clerk2 clerk2){
        this.clerk2 = clerk2;
    }
    @Override
    public void run() {
        while (true){
            clerk2.consumer();
            System.out.println("消费者开始消费");
        }
    }
}