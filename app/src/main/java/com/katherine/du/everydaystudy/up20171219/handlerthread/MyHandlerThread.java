package com.katherine.du.everydaystudy.up20171219.handlerthread;

import android.os.HandlerThread;

/**
 * Created by du on 17/12/15.
 */

public class MyHandlerThread extends HandlerThread {

    private MyHandlerThread(String name) {
        super(name);
    }

    public static MyHandlerThread getInstance(String name) {
        MyHandlerThread thread = new MyHandlerThread(name);
        thread.start();
        return thread;
    }


}
