package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fingerpush.android.FingerPushManager;
import com.fingerpush.android.NetworkUtility;

import org.json.JSONObject;


public class MainActivity extends Main_Font_AppCompatFontActivity {

    final static int MAIN_COLOR = Color.parseColor("#00c3ff");
    final static int SELECTED_COLOR = Color.parseColor("#00c3ff");
    final static int UNSELECTED_COLOR = Color.parseColor("#2b2b2b");

    boolean OPENED = false;

    ViewPager viewPager;
    TabLayout tabLayout;
/*    ImageButton menu;
    DrawerLayout drawerLayout;
    CoordinatorLayout coordinatorLayout;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

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

        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        window.setStatusBarColor(Color.parseColor("#00c3ff"));

        viewPager = (ViewPager)findViewById(R.id.main_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.main_tablayout);
/*        menu = (ImageButton)findViewById(R.id.main_menu);
        drawerLayout = (DrawerLayout)findViewById(R.id.main_drawer_layout);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.main_container);*/

        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(),"신상품")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(),"떙처리")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(),"패키지")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(),"소재")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(InflateTab(getApplicationContext(),"용도")));
        tabLayout.setSelectedTabIndicatorColor(MAIN_COLOR);
        ((TextView)tabLayout.getTabAt(0).getCustomView().findViewById(R.id.tabText)).setTextColor(SELECTED_COLOR);
        TabAdapter tabAdapter = new TabAdapter(getApplicationContext(), getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                ((TextView)tab.getCustomView().findViewById(R.id.tabText)).setTextColor(SELECTED_COLOR);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TextView)tab.getCustomView().findViewById(R.id.tabText)).setTextColor(UNSELECTED_COLOR);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

/*        drawerLayout.setDrawerElevation(0f);
        drawerLayout.setDrawerListener(new Main_DrawerSlideListener(getApplicationContext(), coordinatorLayout, drawerLayout));
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OPENED == false) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
            }
        });*/

    }

    public View InflateTab(Context context, String string) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tab, null);
        TextView name = (TextView)view.findViewById(R.id.tabText);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"AppleSDGothicNeoB.ttf");
        name.setTypeface(typeface);
        name.setText(string);
        return view;
    }

}
