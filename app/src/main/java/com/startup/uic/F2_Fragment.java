package com.startup.uic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class F2_Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    @BindView(R.id.f2_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.f2_button)
    ImageButton button;
    @BindView(R.id.f2_constraint)
    ConstraintLayout constraintLayout;
    @BindView(R.id.f2_category1)
    TextView category1;
    @BindView(R.id.f2_category2)
    TextView category2;
    @BindView(R.id.f2_category3)
    TextView category3;
    @BindView(R.id.f2_category4)
    TextView category4;
    @BindView(R.id.f2_category5)
    TextView category5;
    @BindView(R.id.f2_category6)
    TextView category6;
    @BindView(R.id.f2_category7)
    TextView category7;
    @BindView(R.id.f2_category8)
    TextView category8;
    @BindView(R.id.f2_category9)
    TextView category9;

    MainActivity context;
    Unbinder unbinder;

    boolean changed = false;

    ConstraintSet constraintSet_01;
    ConstraintSet constraintSet_02;

    ArrayList<TextView> textViews;

    int prevClicked = -1;

    Typeface regularFont;
    Typeface semiBoldFont;

    @Override
    public void onAttach(Activity activity) {
        context = (MainActivity) activity;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2_fragment_with_header, container, false);
        unbinder = ButterKnife.bind(this, view);

        textViews = new ArrayList<TextView>(Arrays.asList(
                category1,
                category2,
                category3,
                category4,
                category5,
                category6,
                category7,
                category8,
                category9
        ));

        regularFont = Typeface.createFromAsset(context.getAssets(), "AppleSDGothicNeoR.ttf");
        semiBoldFont = Typeface.createFromAsset(context.getAssets(), "AppleSDGothicNeoSB.ttf");

        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new F2_Adapter(context, inflater));

        constraintSet_01 = new ConstraintSet();
        constraintSet_02 = new ConstraintSet();

        constraintSet_01.clone(constraintLayout);
        constraintSet_02.clone(context, R.layout.f2_fragment_without_header);

        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
        category3.setOnClickListener(this);
        category4.setOnClickListener(this);
        category5.setOnClickListener(this);
        category6.setOnClickListener(this);
        category7.setOnClickListener(this);
        category8.setOnClickListener(this);
        category9.setOnClickListener(this);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f2_button:
                TransitionManager.beginDelayedTransition(constraintLayout);
                rorateImage();
                if (changed) constraintSet_01.applyTo(constraintLayout);
                else constraintSet_02.applyTo(constraintLayout);
                changed = !changed;
                return;
        }

        switch (view.getId()) {
            case R.id.f2_category1:
            case R.id.f2_category2:
            case R.id.f2_category3:
            case R.id.f2_category4:
            case R.id.f2_category5:
            case R.id.f2_category6:
            case R.id.f2_category7:
            case R.id.f2_category8:
            case R.id.f2_category9:
                for(TextView textView : textViews) {
                    textView.setTextColor(Color.parseColor("#2b2b2b"));
                    textView.setTypeface(regularFont);
                }
                ((TextView)view).setTextColor(Color.parseColor("#00c3ff"));
                ((TextView)view).setTypeface(semiBoldFont);
                break;
        }
    }

    private void rorateImage() {
        Drawable drawable = button.getDrawable();
        Bitmap myImg = ((BitmapDrawable) drawable).getBitmap();
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(), matrix, true);
        button.setImageBitmap(rotated);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
