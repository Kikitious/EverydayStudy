package com.katherine.du.everydaystudy.up20171027;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.katherine.du.everydaystudy.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by du on 17/11/8.
 */

public class ParkingDateSelectorActivity extends Activity {
    private static final String TAG = "ParkingDateSelector";


    private List<String> dateList = new ArrayList<>();
    private List<String> timeList = new ArrayList<>();
    private static final String[] MINUTES = {"00", "10", "20", "30", "40", "50"};
    private static final String[] HOURS = {
            "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"
    };
    private static final String[] WEEKS = {
            "周日", "周一", "周二", "周三", "周四", "周五", "周六"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        //initData();
        System.out.println(LongScreenUtils.getVirtualBarHeight(this));
        System.out.println(LongScreenUtils.getHeight1(this));
        System.out.println(LongScreenUtils.getHeight2(this));
    }


    private void initData() {
        //获取当前时间


        //从今天开始的一个月的日期转成String存入dateList
        for (int i = 0; i < 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, i);
            Date date = calendar.getTime();

            int weekNum = calendar.get(Calendar.DAY_OF_WEEK);
            String week = WEEKS[weekNum - 1];

            String dateString = getDate(date);
            dateList.add(dateString + week);
        }


        //初始化时间timeList
        timeList.clear();
        for (int i = 0; i < HOURS.length; i++) {
            for (int j = 0; j < MINUTES.length; j++) {
                timeList.add(HOURS[i] + ":" + MINUTES[j]);
            }
        }

        Log.i(TAG, "dateList:" + dateList.size());
        for (int i = 0; i < dateList.size(); i++) {
            Log.i(TAG, "dateList:" + dateList.get(i));
        }


        Log.i(TAG, "dateList:" + timeList.size());
        for (int i = 0; i < timeList.size(); i++) {
            Log.i(TAG, "timelist:" + timeList.get(i));
        }

        String param = "{\"terminals\":[{\"deptAirportCode\":\"SZX\",\"deptAirportName\":\"深圳宝安国际机场\",\"deptTerminal\":\"T1\",\"terminalId\":\"1\"},{\"deptAirportCode\":\"SZX\",\"deptAirportName\":\"深圳宝安国际机场\",\"deptTerminal\":\"T2\",\"terminalId\":\"2\"},{\"deptAirportCode\":\"SZX\",\"deptAirportName\":\"深圳宝安国际机场\",\"deptTerminal\":\"T3\",\"terminalId\":\"3\"}]}";
        if (!TextUtils.isEmpty(param)) {
            ParkingServiceParam serviceParam = new Gson().fromJson(param, ParkingServiceParam.class);
            List<TerminalsBean> terminals = serviceParam.getTerminals();
            for (int i = 0; i < terminals.size(); i++) {
                Log.i(TAG, "terminals: " + terminals.get(i).getDeptAirportName() + " " + terminals.get(i).getDeptTerminal());
            }
        }



    }




    private String getDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        return sdf.format(date);
    }


}
