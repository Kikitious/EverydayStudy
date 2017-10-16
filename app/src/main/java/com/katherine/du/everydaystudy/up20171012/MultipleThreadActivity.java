package com.katherine.du.everydaystudy.up20171012;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import static android.R.attr.data;
import static android.content.ContentValues.TAG;

/**
 * Created by du on 17/10/12.
 */

public class MultipleThreadActivity extends BaseActivity {


    private DownloadHandler handler = new DownloadHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

    }

    public static class DownloadHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == Msg.SEND_MSG_100.value) {
                //更新UI
            }

        }
    }

    class MyThread implements Runnable {
        @Override
        public void run() {
            //模拟下载任务
            //...
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //更新UI
                    //iv.setImageBitmap(bmp);
                    //tv.setText("update UI");
                }
            });
            Message msg = Message.obtain();
            msg.obj = data;
            msg.what = Msg.SEND_MSG_100.value;
            handler.sendMessage(msg);
        }
    }

    enum Msg {
        SEND_MSG_100(100);
        private int value;

        Msg(int value) {
            this.value = value;
        }
    }

}


class DownloadTask extends AsyncTask<Integer, Integer, String[]> {

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute: This is the first methond");
        super.onPreExecute();
    }

    @Override
    protected String[] doInBackground(Integer... params) {
        for (int i = 0; i <= 100; i++) {
            publishProgress(i);
            try {
                Thread.sleep(params[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new String[]{"执行完毕", ""};
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String[] s) {
        Log.i(TAG, "onPostExecute: " + s);
        super.onPostExecute(s);
    }
}
