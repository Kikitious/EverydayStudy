package com.katherine.du.everydaystudy.up20170925;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.lang.ref.WeakReference;

public class WeakReferenceActivity extends BaseActivity {

    private int page;
    private MyHandler handler = new MyHandler(this);


    public static class MyHandler extends Handler {
        private WeakReference<WeakReferenceActivity> wActivity;

        public MyHandler(WeakReferenceActivity activity) {
            this.wActivity = new WeakReference<WeakReferenceActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (wActivity.get() == null) {
                return;
            }
            WeakReferenceActivity activity = wActivity.get();
            if (msg.what == 1) {
                activity.page++;
            } else {

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = Message.obtain();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();

    }
}
