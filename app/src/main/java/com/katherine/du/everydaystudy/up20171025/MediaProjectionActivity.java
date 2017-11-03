package com.katherine.du.everydaystudy.up20171025;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.nio.ByteBuffer;

public class MediaProjectionActivity extends BaseActivity {

    private MediaProjectionManager manager;
    private int height;
    private int width;
    private int dpi;
    private ImageReader imageReader;
    private VirtualDisplay display;
    private MediaProjection projection;
    static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        handler.postDelayed(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                //获取屏幕的宽高和DPI
                Display display = getWindowManager().getDefaultDisplay();
                DisplayMetrics metrics = new DisplayMetrics();
                display.getMetrics(metrics);
                width = metrics.widthPixels;
                height = metrics.heightPixels;
                dpi = metrics.densityDpi;
                //初始化ImageReader实例
                imageReader = ImageReader.newInstance(width, height, PixelFormat.RGBA_8888, 2);
                //获取MediaProjectionManager实例
                manager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
                //启动截屏Activity【com.android.systemui.media.MediaProjectionPermissionActivity】
                startActivityForResult(manager.createScreenCaptureIntent(), 200);
            }
        }, 1000);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 200) {
            //获取MediaProjection实例
            projection = manager.getMediaProjection(RESULT_OK, data);
            //获取虚拟显示器VirtualDisplay的实例
            display = projection.createVirtualDisplay("ScreenShot",
                    width, height, dpi,
                    DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                    imageReader.getSurface(),
                    null, null);
            //获取截图
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //bitmap即为所得
                    Bitmap bitmap = takeScreenShot();
                }
            }, 1000);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Bitmap takeScreenShot() {
        Bitmap bitmap = null;
        try {
            Image image = imageReader.acquireLatestImage();
            int width = image.getWidth();
            int height = image.getHeight();
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            int rowStride = planes[0].getRowStride();
            int rowPadding = rowStride - pixelStride * width;
            bitmap = Bitmap.createBitmap(width + rowPadding / pixelStride,
                    height, Bitmap.Config.ARGB_8888);
            bitmap.copyPixelsFromBuffer(buffer);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
            image.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (imageReader != null) {
                imageReader.close();
            }
            if (projection != null) {
                projection.stop();
            }
            if (display != null) {
                display.release();
            }
        }
        return bitmap;
    }
}
