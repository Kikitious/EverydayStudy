package com.katherine.du.everydaystudy.up20171019;

import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by du on 17/10/19.
 */

public class BeeperControl {
    private static final String TAG = "BeeperControl";
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "beep");
            }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);

        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 60, TimeUnit.SECONDS);

    }

}
