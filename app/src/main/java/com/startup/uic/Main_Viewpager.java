package com.startup.uic;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 규열 on 2018-01-07.
 */

public class Main_Viewpager extends ViewPager {

    private static final int OFF_SET = 20;
    private float preX;
    private boolean pagingEnabled = true;
    private ViewPagerCallback callback;

    private Boolean EDGE = true;
    private Boolean NOT_EDGE = false;

    public Main_Viewpager(Context context) {
        super(context);
    }

    public Main_Viewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        return super.canScroll(v, checkV, dx, x, y);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                preX = ev.getX();
                Log.d("TAG", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
/*                if (!callback.viewPagercallback()) {
                    return EDGE;
                }
                else {
                    return NOT_EDGE;
                }*/
                Log.d("TAG", "ACTION_MOVE");

                float x = ev.getX();
                if((x - OFF_SET <= preX && preX <= x+ OFF_SET)){
                    Log.d("TAG", "ACTION_A, x : " + x + ", preX : " + preX);
                    return false;
                }else{
                    Log.d("TAG", "ACTION_B, x : " + x + ", preX : " + preX);
                    return true;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setCallback(ViewPagerCallback callback) {
        this.callback = callback;
    }


    public interface ViewPagerCallback{
        boolean viewPagercallback();
    }



}
