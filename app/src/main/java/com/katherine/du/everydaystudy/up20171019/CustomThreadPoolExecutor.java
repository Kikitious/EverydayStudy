package com.katherine.du.everydaystudy.up20171019;

import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by du on 17/10/19.
 */

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {


    static class CustomTask<V> implements RunnableFuture<V> {

        public CustomTask(Callable<V> callable) {
        }

        public CustomTask(Runnable r, V v) {
        }

        @Override
        public void run() {

        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public V get() throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public V get(long timeout, @NonNull TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }

    protected <V> RunnableFuture newTaskFor(Callable<V> c) {
        return new CustomTask<V>(c);
    }

    @Override
    protected <V> RunnableFuture<V> newTaskFor(Runnable runnable, V value) {
        return new CustomTask<V>(runnable, value);
    }

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}
