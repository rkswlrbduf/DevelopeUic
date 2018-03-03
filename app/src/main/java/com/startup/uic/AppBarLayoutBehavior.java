package com.startup.uic;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 규열 on 2018-03-01.
 */

public class AppBarLayoutBehavior extends AppBarLayout.Behavior {

    private int mStartedScrollType = -1;
    private boolean mSkipNextStop;

    private static final int TYPE_FLING = 1;
    boolean isFlinging = false;
    boolean shouldBlockNestedScroll = false;

    public AppBarLayoutBehavior() {
    }

    public AppBarLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        if (mStartedScrollType != -1) {
            onStopNestedScroll(parent, child, target, mStartedScrollType);
            mSkipNextStop = true;
        }
        mStartedScrollType = type;
        return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target, int type) {
        if (mSkipNextStop) {
            mSkipNextStop = false;
            return;
        }
        if (mStartedScrollType == -1) {
            return;
        }
        mStartedScrollType = -1;
        // Always pass TYPE_TOUCH, because want to snap even after fling
        super.onStopNestedScroll(coordinatorLayout, abl, target, ViewCompat.TYPE_TOUCH);
    }

}
