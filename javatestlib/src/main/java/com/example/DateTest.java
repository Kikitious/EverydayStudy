package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by du on 17/11/10.
 */

public class DateTest {

    public static void main(String args[]) {
        String dateString = "2017年11月10日 11:17";
        String week = getWeek(dateString);
        System.out.println(week);

        String s = dateString.substring(5, 11) + " " + week + " " + dateString.substring(12);
        System.out.println(s);
    }

    /**
     * 获取星期数.
     */
    private static String getWeek(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.CHINA);
            Date date = sdf.parse(dateString);
            String[] WEEKS = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return WEEKS[calendar.get(Calendar.DAY_OF_WEEK) - 1];
        } catch (ParseException e) {
            return "";
        }
    }
}
