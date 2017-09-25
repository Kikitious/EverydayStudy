package com.katherine.du.everydaystudy.up20170920;

import android.os.Bundle;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;

/**
 * Created by du on 17/9/20.
 */

public class SingletonTestActivity extends BaseActivity {
    private static final String TAG = "SingletonTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Singleton singleton1 = Singleton.getInstance();
        singleton1.setName("Katherine");
        Log.i(TAG, "singleton1.name = " + singleton1.getName());

        Singleton singleton2 = Singleton.getInstance();
        singleton2.setName("Bella");
        Log.i(TAG, "singleton1.name = " + singleton1.getName());
        Log.i(TAG, "singleton2.name = " + singleton2.getName());

        if (singleton1 == singleton2) {
            Log.i(TAG, "singleton1 is the same as singleton2");
        } else {
            Log.i(TAG, "singleton1 isn't the same as singleton2");
        }

        Singleton singleton3 = Singleton.getInstance();
        Log.i(TAG, "singleton1.name = " + singleton1.getName());
        Log.i(TAG, "singleton2.name = " + singleton2.getName());
        Log.i(TAG, "singleton3.name = " + singleton3.getName());
    }
}
