package com.katherine.du.everydaystudy.up20171219.handlerthread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyHandlerThreadActivity extends BaseActivity {
    private static final String TAG = "MyHandlerThreadActivity";

    private String url = "http://img.blog.csdn.net/20160903083245762";
    private ImageView imageView;
    private Handler uiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            imageView.setImageBitmap((Bitmap) msg.obj);
        }
    };
    private HandlerThread thread;
    private Handler downloadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);
        Log.i(TAG, "Thread.currentThread().getName() = " + Thread.currentThread().getName());

        findView();

        initTask();
    }

    private void findView() {
        imageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    protected void onResume() {
        super.onResume();
        downloadHandler.sendEmptyMessageDelayed(100, 1000);
    }

    private void initTask() {
        thread = new HandlerThread("my-handler-thread");
        thread.start();
        Log.i(TAG, "thread.getName() = " + thread.getName());

        //加载网络图片，耗时任务
        downloadHandler = new Handler(thread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                //加载网络图片，耗时任务
                Bitmap bitmap = downloadUrlBitmap(url);
                Message message = Message.obtain();
                message.what = msg.what;
                message.obj = bitmap;
                uiHandler.sendMessage(message);
            }
        };

    }

    private Bitmap downloadUrlBitmap(String urlString) {
        HttpURLConnection conn = null;
        BufferedInputStream in = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();
            in = new BufferedInputStream(inputStream, 8 * 1024);
            bitmap = BitmapFactory.decodeStream(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.quit();
    }
}
