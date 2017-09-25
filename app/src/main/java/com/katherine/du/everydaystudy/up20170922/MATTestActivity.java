package com.katherine.du.everydaystudy.up20170922;

import android.os.Bundle;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;


public class MATTestActivity extends BaseActivity {

    private static final String TAG = "MATTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_test);
        LeakThread thread = new LeakThread();
        thread.start();
    }

    /**
     * 要是内存不泄露，加static关键字
     */
    private class LeakThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Log.d(TAG, "哈哈哈哈哈哈");
                Thread.sleep(5000 * 3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}



