package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scrollablelayout.ScrollableLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 규열 on 2018-02-05.
 */

public class ItemActivity extends Main_Font_AppCompatFontActivity implements View.OnClickListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.sl_root)
    ScrollableLayout sl_root;
    @BindView(R.id.item_recylcerview)
    RecyclerView recyclerView;
    @BindView(R.id.item_basket)
    Button itemBasketBtn;
    @BindView(R.id.item_buy)
    Button itemBuyBtn;
    @BindView(R.id.item_s2_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.item_s1_imageview)
    ImageView itemImage;
    ItemRecyclerViewAdapter adapter;

    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    int[] location;

    int selectedTab = 0;

    private int mAppBarOffset;
    private boolean mAppBarIdle = false;
    private int mAppBarMaxOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);

        ButterKnife.bind(this);

        location = new int[2];

        adapter = new ItemRecyclerViewAdapter(this, getSupportFragmentManager());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(null);

        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(this);
        recyclerView.addItemDecoration(sectionItemDecoration);

        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab("상품 설명")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab("배송/반품")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab("상품 문의")));

        tabLayout.addOnTabSelectedListener(this);

        sl_root.getHelper().setCurrentScrollableContainer(recyclerView);


        Picasso.with(this).load(url+"image1.png").fit().centerCrop().into(itemImage);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        selectedTab = tab.getPosition();
        adapter.SetSelectedTab(selectedTab);
        adapter.notifyItemChanged(0);
        recyclerView.scrollToPosition(0);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public View InflateTab(String string) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tab, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView name = (TextView) view.findViewById(R.id.tabText);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "AppleSDGothicNeoB.ttf");
        name.setTextColor(Color.parseColor("#2b2b2b"));
        name.setTextSize(14);
        name.setTypeface(typeface);
        name.setText(string);
        return view;
    }

    private int dpToPixels(int dp) {
        return (int) (dp * (this.getResources().getDisplayMetrics().density));
    }

    @Override
    public void onClick(View view) {

    }

}
