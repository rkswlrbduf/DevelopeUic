package com.startup.uic;

import android.support.annotation.FloatRange;
import android.view.View;

import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.yarolegovich.discretescrollview.transform.Pivot;

/**
 * Created by 규열 on 2018-01-18.
 */

public class ViewPagerAnimation implements DiscreteScrollItemTransformer {

    private Pivot pivotX;
    private Pivot pivotY;
    private float minScale;
    private float maxMinDiff;

    public ViewPagerAnimation() {
        pivotX = Pivot.X.CENTER.create();
        pivotY = Pivot.Y.CENTER.create();
        minScale = 0.8f;
        maxMinDiff = 1f;
    }

    @Override
    public void transformItem(View item, float position) {
        pivotX.setOn(item);
        pivotY.setOn(item);
        float closenessToCenter = 1f - Math.abs(position);
        float scale = minScale + maxMinDiff * closenessToCenter;
        item.setScaleX(scale);
        item.setScaleY(scale);
    }

    public static class Builder {

        private ViewPagerAnimation transformer;
        private float maxScale;

        public Builder() {
            transformer = new ViewPagerAnimation();
            maxScale = 1f;
        }

        public ViewPagerAnimation.Builder setMinScale(@FloatRange(from = 0.01) float scale) {
            transformer.minScale = scale;
            return this;
        }

        public ViewPagerAnimation.Builder setMaxScale(@FloatRange(from = 0.01) float scale) {
            maxScale = scale;
            return this;
        }

        public ViewPagerAnimation.Builder setPivotX(Pivot.X pivotX) {
            return setPivotX(pivotX.create());
        }

        public ViewPagerAnimation.Builder setPivotX(Pivot pivot) {
            assertAxis(pivot, Pivot.AXIS_X);
            transformer.pivotX = pivot;
            return this;
        }

        public ViewPagerAnimation.Builder setPivotY(Pivot.Y pivotY) {
            return setPivotY(pivotY.create());
        }

        public ViewPagerAnimation.Builder setPivotY(Pivot pivot) {
            assertAxis(pivot, Pivot.AXIS_Y);
            transformer.pivotY = pivot;
            return this;
        }

        public ViewPagerAnimation build() {
            transformer.maxMinDiff = maxScale - transformer.minScale;
            return transformer;
        }

        private void assertAxis(Pivot pivot, @Pivot.Axis int axis) {
            if (pivot.getAxis() != axis) {
                throw new IllegalArgumentException("You passed a Pivot for wrong axis.");
            }
        }
    }

}
