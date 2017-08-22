package com.katherine.du.everydaystudy.up20170807;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.gaoneng.library.AutoScrollBackLayout;
import com.katherine.du.everydaystudy.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);
        AutoScrollBackLayout autoScrollBackLayout = (AutoScrollBackLayout) findViewById(R.id.scroll_layout);


        List<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add("this is a test! in " + i);
        }

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
        autoScrollBackLayout.bindScrollBack();
    }


}
