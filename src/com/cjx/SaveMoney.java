package com.cjx;

import java.util.concurrent.locks.ReentrantLock;

public class SaveMoney {
    public static void main(String[] args) {
        Account account = new Account(0);
        Person p1 = new Person(account);
        Person p2 = new Person(account);
        p1.setName("用户一");
        p2.setName("用户二");
        p1.start();
        p2.start();
    }

}

class Person extends Thread {
    private Account account;
    public Person (Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.save(1000);
        }
    }
}

class Account {
    private int money;
    private ReentrantLock lock = new ReentrantLock(true);

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public void save(int c) {
        lock.lock();
        if (money >= 0) {
            money += c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为 : " + money);
        }
        lock.unlock();
    }

}