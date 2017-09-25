package com.katherine.du.everydaystudy.up20170918;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/9/18.
 */

public class ViewStubTestActivity extends BaseActivity {

    boolean visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstub_test);
        final View view = ((ViewStub) findViewById(R.id.stub)).inflate();

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!visible) {
                    view.setVisibility(View.VISIBLE);
                    visible = true;
                } else {
                    view.setVisibility(View.INVISIBLE);
                    visible = false;
                }
            }
        });
    }
}
