package com.katherine.du.everydaystudy.up20171027;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by du on 17/10/27.
 */

public class LongScreenShotActivity extends BaseActivity {
    private static final String TAG = "LongScreenShotActivity";
    private Context context;
    private ScrollView scrollView;
    private ListView listView;
    private boolean needJudge = true;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long);
        context = this;
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        new String[]{
                                "哈哈哈",
                                "哈哈哈"
                        }));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
//        if (hasFocus && needJudge) {
//            getScreenParams();
//            LongScreenUtils.saveBitmap(context, LongScreenUtils.getBitmapByListView(listView));
//            needJudge = false;
//        }
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        LongScreenUtils.saveBitmap(this, LongScreenUtils.normalShot(this, false));
        try {
            Class<?> aClass = Class.forName("android.view.Surface");
            Method method = aClass.getMethod("screenshot", new Class[]{int.class, int.class});
            Object o = method.invoke(aClass, new Object[]{width, height});
            Bitmap screen = (Bitmap) o;
            LongScreenUtils.saveBitmap(this, screen);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void getScreenParams() {
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
    }


}
