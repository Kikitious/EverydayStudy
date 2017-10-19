package com.katherine.du.everydaystudy.up20171012;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import static android.content.ContentValues.TAG;

/**
 * Created by du on 17/10/16.
 */

public class HandlerTestActivity extends BaseActivity {


    private static DownloadHandler handler = new DownloadHandler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        new Thread(new DownloadTask()).start();
    }

    private static class DownloadHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                Log.i(TAG, "Handler handleMessage: 下载成功");
            }
        }
    }

    private static class DownloadTask implements Runnable {

        @Override
        public void run() {
            boolean isOver = false;
            //long-running operations
            //假设此处有耗时操作，将isOver置为true
            isOver = true;
            if (isOver) {
                Message msg = Message.obtain();
                msg.what = 100;
                msg.obj = new Object();
                handler.sendMessage(msg);
            }
        }
    }

}
