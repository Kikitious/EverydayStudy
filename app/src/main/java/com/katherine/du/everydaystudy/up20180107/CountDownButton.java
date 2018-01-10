package com.katherine.du.everydaystudy.up20180107;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 18/1/7.
 */

public class CountDownButton extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        final Button button = (Button) findViewById(R.id.count_down_bt);

        final ValueAnimator animator = ValueAnimator.ofInt(0, 60);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object value = animation.getAnimatedValue();
                button.setText(((Integer) value).toString());
            }
        });
        animator.setDuration(60000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });



    }
}
