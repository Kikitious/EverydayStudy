package com.katherine.du.everydaystudy.up20171226.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/12/26.
 */

public class ActivityA extends BaseActivity {

    private static final String TAG = "ActivityA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: A");
        setContentView(R.layout.activity_lifecycle);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this, ActivityB.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: A");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: A");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: A");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: A");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: A");
    }
}
