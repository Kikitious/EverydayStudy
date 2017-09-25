package com.katherine.du.everydaystudy.up20170919;

import android.os.Bundle;
import android.os.Trace;

import com.katherine.du.everydaystudy.BaseActivity;

/**
 * Created by du on 17/9/19.
 */

public class TraceTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void ProcessPeople() {
        Trace.beginSection("ProcessPeople");
        try {
            Trace.beginSection("Processing Jane");
            try {
                //Jane task
            } finally {
                Trace.endSection();
            }
            Trace.beginSection("Processing John");
            try {
                //John task
            } finally {
                Trace.endSection();
            }
        } finally {
            Trace.endSection();
        }

    }

}
