package com.katherine.du.everydaystudy.up20170817;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.katherine.du.everydaystudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是类名描述.
 *
 * created by du at 17/8/22
 */
public class ListViewPositionTestActivity extends Activity {
    private static final String TAG = "ListViewPositionTestAct";
    private ListView listView;
    private List<String> datas;
    private View headerView;
    private View headerView1;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_test);
        Log.i(TAG, "onCreate: jj");
        testMe();

        if (listView == null) {

        }

        initData();

        listView = (ListView) findViewById(R.id.test_lv);

        headerView = LayoutInflater.from(this).inflate(R.layout.activity_position_test_headerview, null);
        headerView1 = LayoutInflater.from(this).inflate(R.layout.activity_position_test_headerview, null);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);

        listView.addHeaderView(headerView);
        listView.addHeaderView(headerView1, "dd", false);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewPositionTestActivity.this, "Position is : " + i, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void testMe() {
        testHe();
    }

    private void testHe() {
        wowo();
    }

    public static void wowo() {
        int i = 0;
        switch (i) {
            case 0:

                break;
            case 1:

                break;
            default:

                break;
        }
    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add("heiehi");
        datas.add("heiehi");
        datas.add("heiehi");
        datas.add("heiehi");
        datas.add("heiehi");
        for (String s : datas) {

        }

        for (int i = 0; i < datas.size(); i++) {

        }

        for (int i = datas.size() - 1; i >= 0; i--) {

        }
    }

    public void test(View view) {
        listView.removeHeaderView(headerView);
    }


}
