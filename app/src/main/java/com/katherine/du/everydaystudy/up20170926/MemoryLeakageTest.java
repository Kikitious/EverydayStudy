package com.katherine.du.everydaystudy.up20170926;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.lang.ref.WeakReference;


public class MemoryLeakageTest extends BaseActivity {
    private String city = "";
    private WeakHandler handler = new WeakHandler(this);

    private static class WeakHandler extends Handler {
        private WeakReference<Context> context;

        private WeakHandler(Context context) {
            this.context = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                MemoryLeakageTest activity = (MemoryLeakageTest) this.context.get();
                activity.city = "Beijing";
                System.out.println(activity.city);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        city = "Shanghai";
        loadData();
    }

    private void loadData() {
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessage(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }


}
