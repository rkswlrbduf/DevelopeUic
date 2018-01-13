package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by 규열 on 2018-01-02.
 */

public class F1_Section1_NewItemPagerAdapter extends PagerAdapter {

    int tabCount;
    Context context;
    LayoutInflater inflater;

    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public F1_Section1_NewItemPagerAdapter(Context context, int tabCount, LayoutInflater inflater) {
        super();
        this.context = context;
        this.tabCount = tabCount;
        this.inflater = inflater;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.f1_section1_viewpager, container, false);
        switch (position) {
            case 0:
                Picasso.with(context).load(url+"f1_section1_1.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.hotitem_imageview));
                break;
            case 1:
                Picasso.with(context).load(url+"f1_section1_2.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.hotitem_imageview));
                break;
            case 2:
                Picasso.with(context).load(url+"f1_section1_3.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.hotitem_imageview));
                break;
        }
        ((ViewPager)container).addView(view, 0);
        Log.d("TAG", "CHECK");
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
