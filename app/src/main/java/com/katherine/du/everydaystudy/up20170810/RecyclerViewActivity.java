package com.katherine.du.everydaystudy.up20170810;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

import java.util.ArrayList;

/**
 * Created by du on 17/8/10.
 */

public class RecyclerViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        RecyclerView recyclerView = new RecyclerView(this);
        ListView listView;
        ArrayList<String> list = new ArrayList<>();
        String remove = list.remove(0);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }
        });

        int touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();

    }

    class e extends View{

        public e(Context context) {
            super(context);
        }

        public void init() {
        }

    }
}
