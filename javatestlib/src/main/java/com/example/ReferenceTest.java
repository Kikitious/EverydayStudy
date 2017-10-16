package com.example;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {

    public static void main(String[] args) {
        //testSoftReference();
        //testSoftReferenceWithQueue();
        //testWeakReference();
        //testWeakReferenceWithQueue();
        //testPhantomReference();
    }


    /**
     * 虚引用
     */
    private static void testPhantomReference() {
        Person person = new Person();
        System.out.println("person对象为" + person);

        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        PhantomReference<Person> pr = new PhantomReference<>(person, queue);
        System.out.println("pr对象为" + pr);
        System.out.println("pr.get()=" + pr.get());

        person = null;
        System.out.println("queue item:" + queue.poll());

        System.gc();

        try {
            //确保垃圾回收线程能够执行
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("queue item: " + queue.poll());
    }

    /**
     * 弱引用
     */
    private static void testWeakReferenceWithQueue() {
        Person person = new Person();
        System.out.println("person对象为" + person);

        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        WeakReference<Person> wr = new WeakReference<Person>(person, queue);
        System.out.println("wr对象为" + wr);

        person = null;

        if (wr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + wr.get());
        }
        System.out.println("Whether or not this reference has been enqueued: " + wr.isEnqueued());
        System.out.println("queue item:" + queue.poll());

        System.gc();

        if (wr.get() == null) {//仅是表明其指示的对象已经进入垃圾回收流程，此时对象不一定已经被垃圾回收。只有确认被垃圾回收后，如果有ReferenceQueue，其引用才会被放置于ReferenceQueue中
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + wr.get());
        }
        try {
            //确保垃圾回收线程能够执行
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Whether or not this reference has been enqueued: " + wr.isEnqueued());
        System.out.println("queue item:" + queue.poll());
    }


    /**
     * 弱引用
     */
    private static void testWeakReference() {
        Person person = new Person();
        System.out.println("person对象为" + person);

        WeakReference<Person> wr = new WeakReference<>(person);
        person = null;
        //被GC后，之前new出的erson对象会立即被回收，进入GC流程

        if (wr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + wr.get());
        }

        System.gc();

        if (wr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + wr.get());
        }
    }

    /**
     * 软引用
     */
    private static void testSoftReferenceWithQueue() {
        Person person = new Person();
        System.out.println("person对象为" + person);

        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        SoftReference<Person> sr = new SoftReference<Person>(person, queue);
        person = null;//之前new出的Person对象不会立即被回收，除非JVM需要内存(OOM之前)

        if (sr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + sr.get());
        }
        System.out.println("加入ReferenceQueue的对象为" + queue.poll());

        System.gc();

        if (sr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + sr.get());
        }
        System.out.println("加入ReferenceQueue的对象为" + queue.poll());
    }

    /**
     * 软引用
     */
    private static void testSoftReference() {
        Person person = new Person();
        System.out.println("person对象为" + person);

        SoftReference<Person> sr = new SoftReference<Person>(person);
        person = null;//之前new出的Person对象不会立即被回收，除非JVM需要内存(OOM之前)

        if (sr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + sr.get());
        }

        System.gc();

        if (sr.get() == null) {
            System.out.println("person对象进入GC流程");
        } else {
            System.out.println("person对象尚未被回收" + sr.get());
        }
    }


    static class Person {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("in Person finalize");
        }
    }

}

class Rst {

}
