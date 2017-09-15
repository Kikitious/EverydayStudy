package com.katherine.du.everydaystudy.up20170807;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

public class AutoScrollBackLayoutTestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_scroll_back_layout_test);
        findViewById(R.id.button_recyclerview).setOnClickListener(this);
        findViewById(R.id.button_listview).setOnClickListener(this);
        findViewById(R.id.button_gridview).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button_recyclerview:
                intent.setClass(this, RecyclerViewDemoActivity.class);
                break;
            case R.id.button_listview:
                intent.setClass(this, ListViewDemoActivity.class);
                break;
            case R.id.button_gridview:
                intent.setClass(this, GridViewDemoActivity.class);
                break;
        }
        startActivity(intent);
    }
}
