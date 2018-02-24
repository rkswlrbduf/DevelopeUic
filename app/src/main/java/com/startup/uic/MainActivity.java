package com.startup.uic;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieImageAsset;
import com.fingerpush.android.FingerPushManager;
import com.fingerpush.android.NetworkUtility;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Main_Font_AppCompatFontActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener, DrawerLayout.DrawerListener {

    final static int MAIN_COLOR = Color.parseColor("#00c3ff");
    final static int SELECTED_COLOR = Color.parseColor("#00c3ff");
    final static int UNSELECTED_COLOR = Color.parseColor("#2b2b2b");

    @BindView(R.id.main_viewpager)
    ViewPager viewPager;
    @BindView(R.id.main_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.main_menu)
    LottieAnimationView menu;
    @BindView(R.id.main_drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.main_drawer_layout_recyclerview)
    RecyclerView drawerRecyclerView;
    @BindView(R.id.main_bag)
    ImageButton main_bag;

    long backKeyPressedTime = 0;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        setStatusColor();
        //setFingerPush();
        setTabLayout();
        setViewPager();
        setDrawer();
        setMainBag();

    }

    private void setMainBag() {
        main_bag.setOnClickListener(this);
    }

    private void setStatusColor() {
        getWindow().setStatusBarColor(Color.parseColor("#00c3ff"));
    }

    private void setFingerPush() {
        FingerPushManager.getInstance(getApplicationContext()).setDevice(new NetworkUtility.ObjectListener() {
            @Override
            public void onComplete(String s, String s1, JSONObject jsonObject) {
                Log.d("TAG", s + " " + s1 + " " + jsonObject);
            }

            @Override
            public void onError(String s, String s1) {
                Log.d("TAG", s + " " + s1);
            }
        });
    }

    private void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(), "홈")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(), "신상품")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(), "Best100")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(), "땡처리")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(), "패키지")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(), "이벤트")));
        tabLayout.setSelectedTabIndicatorHeight((int) dpToPixels(3, getApplicationContext()));
        tabLayout.setSelectedTabIndicatorColor(MAIN_COLOR);
        ((TextView) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.tabText)).setTextColor(SELECTED_COLOR);
        tabLayout.setOnTabSelectedListener(this);
    }

    private void setViewPager() {
        viewPager.setAdapter(new TabAdapter(getApplicationContext(), getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setDrawer() {
        menu.setOnClickListener(this);
        drawerLayout.addDrawerListener(this);
        drawerLayout.setDrawerListener(new Main_DrawerSlideListener(getApplicationContext(), coordinatorLayout, drawerLayout));
        drawerLayout.setDrawerElevation(0f);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        drawerRecyclerView.setAdapter(new Main_DrawerAdapter(MainActivity.this, LayoutInflater.from(this)));
    }

    public View InflateTab(Context context, String string) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tab, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView name = (TextView) view.findViewById(R.id.tabText);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "AppleSDGothicNeoB.ttf");
        name.setTextSize(13);
        name.setTypeface(typeface);
        name.setText(string);
        return view;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        ((TextView) tab.getCustomView().findViewById(R.id.tabText)).setTextColor(SELECTED_COLOR);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        ((TextView) tab.getCustomView().findViewById(R.id.tabText)).setTextColor(UNSELECTED_COLOR);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_menu:
                if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;
            case R.id.main_bag:
                startActivity(new Intent(MainActivity.this, BasketActivity.class));
                break;
        }
    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        menu.setProgress(slideOffset / 2);
    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(getApplicationContext(), "한번 더 누르시면 종료합니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            toast.cancel();
            MainActivity.this.finish();
        }
    }

}
