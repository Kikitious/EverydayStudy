package com.katherine.du.everydaystudy.up20171025;

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
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by du on 17/10/25.
 */

public class MediaProjectionActivity extends BaseActivity {

    private static final String TAG = "MediaProjectionActivity";
    private MediaProjectionManager manager;
    private int height;
    private int width;
    private int dpi;
    private ImageReader imageReader;
    private String imagePath;
    private String imageFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        imagePath = Environment.getExternalStorageDirectory().getPath() + "/Pictures/";
        imageFullName = imagePath + System.currentTimeMillis() + ".png";

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Display display = getWindowManager().getDefaultDisplay();
                DisplayMetrics metrics = new DisplayMetrics();
                display.getMetrics(metrics);
                width = metrics.widthPixels;
                height = metrics.heightPixels;
                dpi = metrics.densityDpi;

                imageReader = ImageReader.newInstance(width, height, PixelFormat.RGBA_8888, 2);
                manager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
                Intent intent = manager.createScreenCaptureIntent();
                startActivityForResult(intent, 200);
            }
        }, 1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200) {
            final MediaProjection projection = manager.getMediaProjection(RESULT_OK, data);
            final VirtualDisplay display = projection.createVirtualDisplay("ScreenShot",
                    width, height, dpi,
                    DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                    imageReader.getSurface(),
                    new VirtualDisplay.Callback() {
                        @Override
                        public void onPaused() {
                            super.onPaused();
                        }
                    }, null);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Image image = imageReader.acquireLatestImage();
                    int width = image.getWidth();
                    int height = image.getHeight();
                    final Image.Plane[] planes = image.getPlanes();
                    final ByteBuffer buffer = planes[0].getBuffer();
                    int pixelStride = planes[0].getPixelStride();
                    int rowStride = planes[0].getRowStride();
                    int rowPadding = rowStride - pixelStride * width;
                    Bitmap bitmap = Bitmap.createBitmap(width + rowPadding / pixelStride,
                            height, Bitmap.Config.ARGB_8888);
                    bitmap.copyPixelsFromBuffer(buffer);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
                    image.close();
                    try {
                        if (bitmap != null) {
                            File dir = new File(imagePath);
                            if (!dir.exists()) {
                                dir.mkdirs();
                            }
                            File fileImage = new File(imageFullName);
                            if (!fileImage.exists()) {
                                fileImage.createNewFile();
                            }
                            FileOutputStream out = new FileOutputStream(fileImage);
                            if (out != null) {
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                                out.flush();
                                out.close();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (imageReader != null) {
                            imageReader.close();
                            imageReader = null;
                        }
                        if (projection != null) {
                            projection.stop();
                        }
                        if (display != null) {
                            display.release();
                        }
                    }

                }
            }, 1000);

        }

    }
}
