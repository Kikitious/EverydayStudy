package com.katherine.du.everydaystudy.up20171012;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/10/17.
 */

public class AsyncTaskTestActivity extends BaseActivity {
    private static final String TAG = "AsyncTaskTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        Log.i(TAG, "CPU_COUNT = " + CPU_COUNT);//6个！！！！

        new DownloadTask().execute("Input");
    }


    private static class DownloadTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected String doInBackground(String... params) {
            Log.i(TAG, "doInBackground: params is " + params[0]);
            String result = "";
            if (params[0].equals("Input")) {
                result = "Output";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i(TAG, "onPostExecute: result is " + s);
        }

    }


}
