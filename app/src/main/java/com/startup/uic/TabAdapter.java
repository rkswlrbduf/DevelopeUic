package com.startup.uic;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class TabAdapter extends FragmentStatePagerAdapter {

    Context context;
    int tabCount;

    public TabAdapter(Context context, FragmentManager fm, int tabCount) {
        super(fm);
        this.context = context;
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new F0_Fragment();
            case 1:
                return new F1_Fragment();
            case 2:
                return new F2_Fragment();
            case 3:
                return new F3_Fragment();
            case 4:
                return new F4_Fragment();
            case 5:
                return new F5_Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
