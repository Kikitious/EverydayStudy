package com.katherine.du.everydaystudy.up20171226.activity;

import android.os.Bundle;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;

/**
 * Created by du on 17/12/26.
 */

public class ActivityB extends BaseActivity {

    private static final String TAG = "ActivityB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: B");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: B");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: B");
    }
}
