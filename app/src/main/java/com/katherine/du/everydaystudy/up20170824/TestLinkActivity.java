package com.katherine.du.everydaystudy.up20170824;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.katherine.du.everydaystudy.R;

import java.util.ArrayList;
import java.util.List;

public class TestLinkActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_link);

        List<String> links = new ArrayList<>();
        links.add("http://www.baidu.com");
        links.add("http://www.baidu.com");
        links.add("http://www.baidu.com");


        String notice1, notice2, notice3;
        notice1 = getString(R.string.cki_confirm_notice1);
        notice2 = getString(R.string.cki_confirm_notice2);
        notice3 = getString(R.string.cki_confirm_notice3);
        String notice;
        notice = String.format(
                getResources().getString(R.string.check_info_notice_magic_order),
                notice1,
                notice2,
                notice3);
        int end3 = notice.length();
        int start3 = end3 - notice3.length() - 2;
        int end2 = start3 - 1;
        int start2 = end2 - notice2.length() - 2;
        int end1 = start2 - 1;
        int start1 = end1 - notice1.length() - 2;


        SpannableString sp = new SpannableString(notice);
        if (!TextUtils.isEmpty(notice1) && links != null) {
            String link1 = links.get(0);
            if (!TextUtils.isEmpty(link1)) {
                sp.setSpan(new MYURLSpan(link1),
                        start1,
                        end1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                sp.setSpan(
                        new ForegroundColorSpan(Color.RED),
                        start1,
                        end1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }


        if (!TextUtils.isEmpty(notice2) && links != null) {
            String link2 = links.get(1);
            if (!TextUtils.isEmpty(link2)) {
                sp.setSpan(new MYURLSpan(links.get(1)),
                        start2,
                        end2,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                sp.setSpan(
                        new ForegroundColorSpan(Color.RED),
                        start2,
                        end2,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        if (!TextUtils.isEmpty(notice3) && links != null) {
            String link3 = links.get(2);
            if (!TextUtils.isEmpty(link3)) {
                sp.setSpan(new MYURLSpan(links.get(1)),
                        start3,
                        end3,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                sp.setSpan(
                        new ForegroundColorSpan(Color.RED),
                        start3,
                        end3,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }


        ((TextView) findViewById(R.id.input)).setText(sp);
    }

    private class MYURLSpan extends URLSpan {

        public MYURLSpan(String url) {
            super(url);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {

        }
    }

}
