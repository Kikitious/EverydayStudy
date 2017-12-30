package com.katherine.du.everydaystudy.up20171227;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Scroller;

/**
 * Created by du on 17/12/30.
 */

public class ScrollTextView extends android.support.v7.widget.AppCompatTextView {
    private static final String TAG = "ScrollTextView";
    private int mLastY;
    private int mLastX;
    private Scroller scroller;

    public ScrollTextView(Context context) {
        super(context);
        init(context);
    }

    public ScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        scroller = new Scroller(context);
    }

    public void smoothScrollTo(int destX) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        scroller.startScroll(scrollX, 0, -deltaX, 0, 2000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: hahah");
        return true;
    }
}
