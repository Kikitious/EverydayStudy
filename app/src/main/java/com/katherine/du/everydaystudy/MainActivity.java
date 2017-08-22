package com.katherine.du.everydaystudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(test());
    }

    public static String test() {


        return String.valueOf(inc(10) + inc(8) + inc(-10));
    }

    public static int inc(int temp) {
        if (temp > 0) {
            return temp * 2;
        }
        return -1;
    }

}
