package com.example;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {

    public static void main(String[] args) {
        //testSoftReference();
        testWeakReference();
        //testWeakReferenceWithQueue();

    }

    private static void testWeakReferenceWithQueue() {
        A a = new A();
        System.out.println("a对象为" + a);

        ReferenceQueue<A> rq = new ReferenceQueue<>();
        WeakReference<A> wrA = new WeakReference<A>(a, rq);
        System.out.println("wrA对象为" + wrA);

        a = null;

        if (wrA.get() == null) {
            System.out.println("a对象进入GC流程");
        } else {
            System.out.println("a对象尚未被回收" + wrA.get());
        }
        System.out.println("Whether or not this reference has been enqueued: " + wrA.isEnqueued());
        System.out.println("rq item:" + rq.poll());

        System.gc();

        if (wrA.get() == null) {//仅是表明其指示的对象已经进入垃圾回收流程，此时对象不一定已经被垃圾回收。只有确认被垃圾回收后，如果有ReferenceQueue，其引用才会被放置于ReferenceQueue中
            System.out.println("a对象进入GC流程");
        } else {
            System.out.println("a对象尚未被回收" + wrA.get());
        }
        try {
            //确保垃圾回收线程能够执行
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Whether or not this reference has been enqueued: " + wrA.isEnqueued());
        System.out.println("rq item:" + rq.poll());

    }


    /**
     * 弱引用存在的意义
     */
    private static void testWeakReference() {
        A a = new A();
        System.out.println("a对象为" + a);

        WeakReference<A> wrA = new WeakReference<>(a);
        a = null;
        //之前new出的A对象会立即被回收，进入GC流程

        if (wrA.get() == null) {
            System.out.println("a对象进入GC流程");
        } else {
            System.out.println("a对象尚未被回收" + wrA.get());
            A person = wrA.get();
        }

        System.gc();

        if (wrA.get() == null) {
            System.out.println("a对象进入GC流程");
        } else {
            System.out.println("a对象尚未被回收" + wrA.get());
            A person = wrA.get();
        }


    }


    /**
     * 软引用
     */
    private static void testSoftReference() {
        A a = new A();
        System.out.println("a对象为" + a);

        SoftReference<A> srA = new SoftReference<A>(a);
        a = null;
        //之前new出的A对象不会立即被回收，除非JVM需要内存(OOM之前)

        if (srA.get() == null) {
            System.out.println("a对象进入GC流程");
        } else {
            System.out.println("a对象尚未被回收" + srA.get());
            A person = srA.get();
        }

        System.gc();

        if (srA.get() == null) {
            System.out.println("a对象进入GC流程");
        } else {
            System.out.println("a对象尚未被回收" + srA.get());
            A person = srA.get();
        }
    }


    static class A {

        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("in A finalize");
        }
    }

}
