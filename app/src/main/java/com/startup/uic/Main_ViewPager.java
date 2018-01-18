package com.startup.uic;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 규열 on 2018-01-18.
 */

public class Main_ViewPager extends ViewPager implements NestedScrollingParent {

    private View nestedScrollTarget = null;
    private boolean nestedScrollTargetIsBeingDragged = false;
    private boolean nestedScrollTargetWasUnableToScroll = false;
    private boolean skipsTouchInterception = false;

    public NestedRecyclerVIew(Context context) {
        super(context);
    }

    public NestedRecyclerVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean temporarilySkipsInterception = nestedScrollTarget != null;
        if (temporarilySkipsInterception) {
            skipsTouchInterception = true;
        }

        boolean handled = super.dispatchTouchEvent(ev);

        if (temporarilySkipsInterception) {
            skipsTouchInterception = false;
            if(!handled || nestedScrollTargetWasUnableToScroll) {
                handled = super.dispatchTouchEvent(ev);
            }
        }
        Log.d("TDT", "DISPATCH TOUCH");
        return handled;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.d("TDT", "INTERCEPT TOUCH : " + skipsTouchInterception);
        return !skipsTouchInterception && super.onInterceptTouchEvent(e);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if(target == nestedScrollTarget && !nestedScrollTargetIsBeingDragged) {
            if(dxConsumed != 0) {
                nestedScrollTargetIsBeingDragged = true;
                nestedScrollTargetWasUnableToScroll = false;
            } else if(dxConsumed == 0 && dxUnconsumed != 0) {
                nestedScrollTargetWasUnableToScroll = true;
                target.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        Log.d("TDT", "NESTED SCROLL");
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        if(axes == View.SCROLL_AXIS_HORIZONTAL) {
            nestedScrollTarget = target;
            Log.d("TDT", "NESTED ACCEPTED : " + nestedScrollTarget.toString());
            nestedScrollTargetIsBeingDragged = false;
            nestedScrollTargetWasUnableToScroll = false;
        }
        super.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.d("TDT", "START NESTED" + String.valueOf(nestedScrollAxes == View.SCROLL_AXIS_HORIZONTAL));
        return nestedScrollAxes == View.SCROLL_AXIS_HORIZONTAL;
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.d("TDT", "STOP NESTED");
        nestedScrollTarget = null;
        nestedScrollTargetIsBeingDragged = false;
        nestedScrollTargetWasUnableToScroll = false;
    }

}
