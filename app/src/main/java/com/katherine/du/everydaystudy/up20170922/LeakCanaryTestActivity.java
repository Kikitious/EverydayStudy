package com.katherine.du.everydaystudy.up20170922;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/9/22.
 */
public class LeakCanaryTestActivity extends BaseActivity {

    private static final String TAG = "MATTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_test);
        //典型Handler导致的内存泄漏
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "哈哈哈哈哈哈");
            }
        }, 100000l);
    }

}
