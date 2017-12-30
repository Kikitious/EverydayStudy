package com.katherine.du.everydaystudy.up20171227;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/12/27.
 */

public class DownloadActivirty extends BaseActivity {

    private static final String TAG = "DownloadActivirty";
    private ScrollTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        textView = (ScrollTextView) findViewById(R.id.tv);

        Button bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method6();
            }
        });


        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int top = bt.getTop();
                Log.i(TAG, "onCreate: " + top);

                int[] outLocation = new int[2];
                bt.getLocationOnScreen(outLocation);
                int top1 = outLocation[1];
                Log.i(TAG, "onCreate: " + top1);

                int[] outLocation1 = new int[2];
                bt.getLocationInWindow(outLocation1);
                int top2 = outLocation1[1];
                Log.i(TAG, "onCreate: " + top2);
            }
        }, 2000);*/


    }

    private void method6() {
        handler.sendEmptyMessage(1);
    }

    private int count = 0;
    private int totalCount = 30;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    count++;
                    if (count <= totalCount) {
                        float fraction = count / (float) totalCount;
                        int scrollX = (int) (fraction * 100);
                        textView.scrollTo(-scrollX, 0);
                        handler.sendEmptyMessageDelayed(1, 33);
                    }
                    break;
            }
        }
    };

    private void method5() {
        textView.smoothScrollTo(50);
    }

    private void method4() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 1);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                textView.scrollTo((int) (-300 * fraction), 0);
            }
        });
        animator.start();
    }

    private void method1() {
        //textView.scrollTo(0 - 50, 0);
        textView.scrollBy(0 - 50, 0);
    }

    private void method3() {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        params.leftMargin += 100;
        textView.requestLayout();
    }

    private void method2() {
        ObjectAnimator ani = ObjectAnimator.ofFloat(textView, "translationX", 0, 100);
        ani.setDuration(2000);
        ani.start();
    }

}
