package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 규열 on 2018-02-27.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    final static int SECTION1 = 100;
    final static int SECTION2 = 101;
    final static int SECTION3_1 = 102;
    final static int SECTION3_2 = 103;
    final static int SECTION3_3 = 104;

    final static int SECTION_COUNT = 1;

    int selectedTab = 0;

    Context context;
    FragmentManager fm;

    public ItemRecyclerViewAdapter(Context context, FragmentManager fm) {
        super();
        this.context = context;
        this.fm = fm;
    }

    public void SetSelectedTab(int selectedTab) {
        this.selectedTab = selectedTab;
        Log.d("TAG", "SELECTED_TAB : " + selectedTab);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case SECTION3_1:
                view = LayoutInflater.from(context).inflate(R.layout.item_s3_1, parent, false);
                return new Section3_1ViewHolder(view);
            case SECTION3_2:
                view = LayoutInflater.from(context).inflate(R.layout.item_s3_2, parent, false);
                return new Section3_2ViewHolder(view);
            case SECTION3_3:
                view = LayoutInflater.from(context).inflate(R.layout.item_s3_3, parent, false);
                return new Section3_3ViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return SECTION_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                switch (selectedTab) {
                    case 0:
                        return SECTION3_1;
                    case 1:
                        return SECTION3_2;
                    case 2:
                        return SECTION3_3;
                }
            default:
                return -1;
        }
    }

    class Section3_1ViewHolder extends RecyclerView.ViewHolder {

        public Section3_1ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    class Section3_2ViewHolder extends RecyclerView.ViewHolder {

        public Section3_2ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    class Section3_3ViewHolder extends RecyclerView.ViewHolder {

        public Section3_3ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }



    public View InflateTab(Context context, String string) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_tab, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView name = (TextView) view.findViewById(R.id.tabText);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "AppleSDGothicNeoB.ttf");
        name.setTextColor(Color.parseColor("#2b2b2b"));
        name.setTextSize(14);
        name.setTypeface(typeface);
        name.setText(string);
        return view;
    }

}
