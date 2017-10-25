package com.katherine.du.everydaystudy.up20171025;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/10/25.
 */

public class FilePathActivity extends BaseActivity {
    private static final String TAG = "FilePathActivity";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        context = this;
        Log.i(TAG, context.getFilesDir().toString());
        Log.i(TAG, context.getCacheDir().toString());
        Log.i(TAG, Environment.getDataDirectory().toString());
        Log.i(TAG, Environment.getRootDirectory().toString());
        Log.i(TAG, Environment.getDownloadCacheDirectory().toString());

        Log.i(TAG, context.getExternalCacheDir().toString());
        Log.i(TAG, context.getExternalFilesDir(null).toString());
        Log.i(TAG, context.getExternalFilesDir("katherine").toString());

        Log.i(TAG, Environment.getExternalStorageDirectory().toString());
        Log.i(TAG, Environment.getExternalStoragePublicDirectory("katherine").toString());
    }


}
