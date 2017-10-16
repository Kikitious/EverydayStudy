package com.example.multiplethreads;

/**
 * Created by du on 17/10/12.
 */

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("1 goes to run()");
        try {
            Thread.sleep(10000);
            System.out.println("2 sleep is over");
        } catch (InterruptedException e) {
            System.out.println("3 sleep is forbidden");
            e.printStackTrace();
            return;
        }
        System.out.println("4 run() is over");
    }
}

class ScaleTicketThread implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            scale();
        }
    }

    private synchronized void scale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票： ticket = " + ticket);
            ticket--;
        }
    }
}

public class MultipleThreadsTest {

    public static void main(String args[]) {
        ScaleTicketThread thread = new ScaleTicketThread();
        Thread t1 = new Thread(thread, "影院1");
        Thread t2 = new Thread(thread, "影院2");
        Thread t3 = new Thread(thread, "影院3");
        t1.start();
        t2.start();
        t3.start();


        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }

}