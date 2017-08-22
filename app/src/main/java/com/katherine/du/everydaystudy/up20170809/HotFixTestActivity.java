package com.katherine.du.everydaystudy.up20170809;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/8/9.
 */
public class HotFixTestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotfix_test);
        TextView tv = (TextView) findViewById(R.id.tv_sophix);
        tv.setText("You are my sunshine");
    }

}
