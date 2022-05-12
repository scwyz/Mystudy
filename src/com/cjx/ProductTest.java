package com.cjx;

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk(0);
        Producer p = new Producer(clerk);
        Thread t1 = new Thread(p);
        t1.setName("生产者");

        Consumer c = new Consumer(clerk);
        Thread t2 = new Thread(c);
        t2.setName("消费者");

        t1.start();
        t2.start();
    }
}

class Clerk {
    public Clerk() {
    }

    public int commodity;

    public Clerk(int commodity) {
        this.commodity = commodity;
    }

    public synchronized void produce() {
        if (commodity < 20){
            commodity++;
            System.out.println(Thread.currentThread().getName()+"生产成功，现在商品："+commodity);
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume(){
        if (commodity > 0 ){
            commodity --;
            System.out.println(Thread.currentThread().getName()+"消费成功，现在商品："+commodity);
            notify();

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

class Producer implements Runnable {
    public Producer() {
    }

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产");
        while (true){
            clerk.produce();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer() {
    }

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费");
        while (true){
            clerk.consume();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
