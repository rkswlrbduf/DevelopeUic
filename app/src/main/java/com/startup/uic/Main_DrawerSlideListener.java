package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by 규열 on 2018-01-08.
 */

public class Main_DrawerSlideListener implements DrawerLayout.DrawerListener {

    Context context;
    CoordinatorLayout coordinatorLayout;
    DrawerLayout drawerLayout;

    Main_DrawerSlideListener(Context context, CoordinatorLayout coordinatorLayout, DrawerLayout drawerLayout) {
        this.context = context;
        this.coordinatorLayout = coordinatorLayout;
        this.drawerLayout = drawerLayout;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        coordinatorLayout.setTranslationX(slideOffset * drawerView.getWidth());
        int black_color = Color.parseColor("#000000") + 1;
        int white_color = Color.parseColor("#ff00ff");
        Log.d("TAG", String.valueOf((int)(slideOffset * 255)));

        drawerLayout.setBackgroundColor(Color.argb((int)(slideOffset * 255), 0, 195, 255));
        coordinatorLayout.setScaleX(1 - (0.2f * slideOffset));
        coordinatorLayout.setScaleY(1 - (0.2f * slideOffset));
        drawerLayout.bringChildToFront(drawerView);
        drawerLayout.requestLayout();
    }

    @Override
    public void onDrawerOpened(View drawerView) {
    }

    @Override
    public void onDrawerClosed(View drawerView) {
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
