package com.example.multiplethreads;

/**
 * Created by du on 17/10/12.
 */

public class DeadLockTest implements Runnable {

    private static ZhangSan zs = new ZhangSan();
    private static Lisi ls = new Lisi();
    private boolean flag = false;


    @Override
    public void run() {
        if (flag) {
            synchronized (zs) {
                zs.say();
                synchronized (ls) {
                    zs.get();
                }

            }
        } else {
            synchronized (ls) {
                ls.say();
                synchronized (zs) {
                    ls.get();
                }
            }
        }
    }

    public static void main(String args[]) {
        DeadLockTest l = new DeadLockTest();
        DeadLockTest m = new DeadLockTest();
        l.flag = true;
        m.flag = false;
        Thread t1 = new Thread(l, "Thread1");
        Thread t2 = new Thread(m, "Thread2");
        t1.start();
        t2.start();
    }
}

class ZhangSan {
    public void say() {
        System.out.println("Zhangsan said to Lisi : Give me your picture, I will give you the book");
    }

    public void get() {
        System.out.println("Zhangsan get the picture");
    }
}

class Lisi {
    public void say() {
        System.out.println("Lisi said to Zhangsan : Give me your book, I will give you the picture");
    }

    public void get() {
        System.out.println("Lisi get the book");
    }
}

