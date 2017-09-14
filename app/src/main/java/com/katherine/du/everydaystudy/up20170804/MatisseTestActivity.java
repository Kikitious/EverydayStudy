package com.katherine.du.everydaystudy.up20170804;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import com.katherine.du.everydaystudy.R;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

public class MatisseTestActivity extends Activity {

    private static final int REQUEST_CODE_CHOOSE = 0X100;
    private static final int PERMISSION_REQUEST_CODE = 0x101;
    private final String[] PERMISSIONS = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matisse_test);
        context = this;

        //请求运行时权限
        //"新的运行时权限机制"只在应用程序的targetSdkVersion>=23时生效，并且只在6.0系统之上有这种机制，在低于6.0的系统上应用程序和以前一样不受影响。
        if (getApplicationInfo().targetSdkVersion >= 23 && Build.VERSION.SDK_INT >= 23) {
            requestPermission();
        } else {//当前应用程序的targetSdkVersion小于23（为22），系统会默认其尚未适配新的运行时权限机制，安装后将和以前一样不受影响：即用户在安装应用程序的时候默认允许所有被申明的权限
            startOpenGellery();
        }


    }


    /**
     * 请求读写存储的权限
     */
    private void requestPermission() {
        if (!checkPermission()) {//如果没有权限则请求权限,"新的运行时权限机制"申请权限的Dialog并不会自动弹出，开发者必须手动申明调用
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQUEST_CODE);
        } else {//如果有权限则直接写
            startOpenGellery();
        }
    }

    /**
     * 检测是否有读写权限，没有返回FALSE；有则返回TRUE
     */
    private boolean checkPermission() {
        for (String permission : PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                // 只要有一个权限没有被授予, 则直接返回 false
                return false;
            }
        }
        return true;
    }

    /**
     * 权限请求的返回结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            boolean isAllGranted = true;
            for (int grant : grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false;
                    break;
                }
            }
            if (isAllGranted) {
                startOpenGellery();
            } else {//权限被拒绝，不能写
                Toast.makeText(context, "没有读写权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startOpenGellery() {
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int photoSize = (int) (width / getResources().getDisplayMetrics().density + 0.5f);

        Matisse.from(this)
                .choose(MimeType.allOf())
                .countable(true)
                .maxSelectable(9)
                //.gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.matisse_photo_size))
                .gridExpectedSize(photoSize)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .theme(R.style.Matisse_Zhihu)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            Log.i(MatisseTestActivity.class.getSimpleName(), uris.toString());
        }
    }
}
