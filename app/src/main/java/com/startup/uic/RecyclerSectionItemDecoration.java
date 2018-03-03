package com.startup.uic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 규열 on 2018-02-28.
 */

public class RecyclerSectionItemDecoration extends RecyclerView.ItemDecoration {

    Context context;
    View tabView;

    public RecyclerSectionItemDecoration(Context context) {
        this.context = context;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        if (tabView == null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                if (parent.getChildAt(i).getId() == R.id.item_s2_container) {
                    tabView = parent.getChildAt(i);
                    break;
                }
            }
        }

    }



    private void drawHeader(Canvas c, View headerView) {
        c.save();
        c.translate(0, 0);
        headerView.draw(c);
        c.restore();
    }

}

