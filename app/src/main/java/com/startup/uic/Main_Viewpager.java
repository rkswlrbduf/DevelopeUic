package com.startup.uic;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by 규열 on 2018-01-07.
 */

public class Main_Viewpager extends ViewPager {

    private static final int OFF_SET = 50;

    private float preX;

    public Main_Viewpager(Context context) {
        super(context);
    }

    public Main_Viewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action){
            case MotionEvent.ACTION_DOWN:
                preX = ev.getX();
                Log.d("TAG", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("TAG", "ACTION_MOVE");

                float x = ev.getX();
                if((x - OFF_SET <= preX && preX <= x+ OFF_SET)){
                    Log.d("TAG", "ACTION_A");
                    return false;
                }else{
                    Log.d("TAG", "ACTION_B");
                    return true;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

}
