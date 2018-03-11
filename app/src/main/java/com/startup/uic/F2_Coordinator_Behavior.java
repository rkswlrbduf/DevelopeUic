package com.startup.uic;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 규열 on 2018-03-10.
 */

public class F2_Coordinator_Behavior extends CoordinatorLayout.Behavior {

    public F2_Coordinator_Behavior() {
        super();
    }

    public F2_Coordinator_Behavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.d("TAG", dependency.getBottom()+ "");
        child.setTranslationY(dependency.getBottom());
        return true;
    }

}
