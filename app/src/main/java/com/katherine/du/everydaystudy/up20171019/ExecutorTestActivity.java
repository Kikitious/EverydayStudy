package com.katherine.du.everydaystudy.up20171019;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by du on 17/10/19.
 */

public class ExecutorTestActivity extends BaseActivity {
    private static final String TAG = "ExecutorTestActivity";

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE_SECONDS = 30;

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }
    };

    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(128);

    public static final Executor THREAD_POOL_EXECUTOR;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
                sPoolWorkQueue, sThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        SerialExecutor exec = new SerialExecutor(THREAD_POOL_EXECUTOR);
        for (int i = 0; i < 50; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "currentThreadName = " + Thread.currentThread().getName());
                }
            });
        }

    }


    class SerialExecutor implements Executor {

        final Queue<Runnable> tasks = new ArrayDeque<>();
        final Executor executor;
        Runnable active;

        public SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        @Override
        public void execute(@NonNull final Runnable command) {
            tasks.offer(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        scheduleNext();
                    }
                }
            });
            if (active == null) {
                scheduleNext();
            }
        }

        private void scheduleNext() {
            if ((active = tasks.poll()) != null) {
                Log.i(TAG, "active: " + Thread.currentThread().getName());
                executor.execute(active);
            }
        }
    }


}
