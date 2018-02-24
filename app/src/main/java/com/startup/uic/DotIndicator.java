package com.startup.uic;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by 규열 on 2018-01-19.
 */

public class DotIndicator extends RecyclerView.ItemDecoration {

    private int colorActive = Color.parseColor("#ffffff");

    int activePosition;

    private static final float DP = Resources.getSystem().getDisplayMetrics().density;

    private final int mIndicatorBottomPadding = (int) (DP * 20);
    private final float mIndicatorItemRadius = DP * 3.3f;
    private final float mIndicatorItemPadding = DP * 12;
    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();

    private final Paint mPaint = new Paint();

    public DotIndicator() {
        activePosition = 0;
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(colorActive);
        mPaint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int itemCount = parent.getAdapter().getItemCount();

        float totalLength = mIndicatorItemRadius * itemCount;
        float paddingBetweenItems = Math.max(0, itemCount - 1) * mIndicatorItemPadding;
        float indicatorTotalWidth = totalLength + paddingBetweenItems;
        float indicatorStartX = (parent.getWidth() - indicatorTotalWidth) / 10F;

        float indicatorPosY = parent.getHeight() - mIndicatorBottomPadding;

        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        activePosition = layoutManager.findFirstVisibleItemPosition();
        if (activePosition == RecyclerView.NO_POSITION) {
            return;
        }

        final View activeChild = layoutManager.findViewByPosition(activePosition);
        int left = activeChild.getLeft();
        int width = activeChild.getWidth();

        float progress = mInterpolator.getInterpolation(left * -1 / (float) width);
        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, mIndicatorItemRadius, itemCount);
        drawHighlights(c, indicatorStartX, indicatorPosY, activePosition, mIndicatorItemRadius, progress, itemCount);

    }

    private void drawInactiveIndicators(Canvas c, float indicatorStartX, float indicatorPosY, float mIndicatorItemRadius, int itemCount) {

        final float itemWidth = mIndicatorItemRadius + mIndicatorItemPadding;

        float start = indicatorStartX;
        for (int i = 0; i < itemCount; i++) {
            c.drawCircle(start, indicatorPosY, mIndicatorItemRadius, mPaint);
            start += itemWidth;
        }

    }

    private void drawHighlights(Canvas c, float indicatorStartX, float indicatorPosY, int highlightPosition,float mIndicatorItemRadius, float progress, int itemCount) {

        final float itemWidth = mIndicatorItemRadius + mIndicatorItemPadding;

        if (progress == 0F) {
            float highlightStart = indicatorStartX + itemWidth * highlightPosition;
            c.drawCircle(highlightStart, indicatorPosY, mIndicatorItemRadius * 1.3f, mPaint);
        } else {
            float highlightStart = indicatorStartX + itemWidth * highlightPosition;
            float partialLength = 1.3f * progress;
            c.drawCircle(highlightStart, indicatorPosY, mIndicatorItemRadius, mPaint);
            if (highlightPosition < itemCount - 1) {
                highlightStart += itemWidth;
                c.drawCircle(highlightStart, indicatorPosY, mIndicatorItemRadius * partialLength, mPaint);
            }
        }
    }
}
