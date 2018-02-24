package com.startup.uic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by 규열 on 2018-02-12.
 */

public class CustomCardView extends CardView {

    int initialHeight;
    int distanceToExpand;
    int distanceToCollapse;
    Context context;
    boolean state;

    public CustomCardView(@NonNull Context context) {
        super(context);
        this.context = context;
        state = false;
    }

    @Override
    public void setUseCompatPadding(boolean useCompatPadding) {
        super.setUseCompatPadding(useCompatPadding);
    }

    public CustomCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        state = false;
    }

    public CustomCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        state = false;
    }

    public void click() {
        if (!state) collapse();
        else expand();
        state = !state;
    }

    private void expand() {
        initialHeight = getHeight();

        measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int targetHeight = getMeasuredHeight();

        distanceToExpand = targetHeight - initialHeight;

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    // Do this after expanded
                }

                getLayoutParams().height = (int) (initialHeight + (distanceToExpand * interpolatedTime));
                requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToExpand);
        startAnimation(a);
    }

    private void collapse() {
        measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        initialHeight = getMeasuredHeight();

        distanceToCollapse = (int) (initialHeight - 147);

        Log.d("TAG", dpToPixels(34)+"");

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                getLayoutParams().height = (int) (initialHeight - (distanceToCollapse * interpolatedTime));
                requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((long) distanceToCollapse);
        startAnimation(a);
    }

    private int dpToPixels(int dp) {
        return (int) (dp * (context.getResources().getDisplayMetrics().density));
    }

}
