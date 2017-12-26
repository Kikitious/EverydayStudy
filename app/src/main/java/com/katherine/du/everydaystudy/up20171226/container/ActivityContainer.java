package com.katherine.du.everydaystudy.up20171226.container;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/12/26.
 */

public class ActivityContainer extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, new FragmentA());
        transaction.commit();
    }
}
