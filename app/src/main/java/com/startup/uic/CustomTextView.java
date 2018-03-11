package com.startup.uic;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 규열 on 2018-03-10.
 */


public class CustomTextView extends AppCompatTextView {

    private TextViewStateListener listener;

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnTextViewStateListener(TextViewStateListener listener) {
        this.listener = listener;
    }

}



