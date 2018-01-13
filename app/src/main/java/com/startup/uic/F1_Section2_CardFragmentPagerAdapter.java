package com.startup.uic;

/**
 * Created by 규열 on 2018-01-05.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class F1_Section2_CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

    private List<F1_Section2_CardFragment> fragments;
    private float baseElevation;

    public F1_Section2_CardFragmentPagerAdapter(FragmentManager fm, float baseElevation) {
        super(fm);
        fragments = new ArrayList<>();
        this.baseElevation = baseElevation;

        for(int i = 0; i< 8; i++){
            addCardFragment(new F1_Section2_CardFragment());
        }

    }

    @Override
    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return fragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return F1_Section2_CardFragment.getInstance(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        fragments.set(position, (F1_Section2_CardFragment) fragment);
        return fragment;
    }

    public void addCardFragment(F1_Section2_CardFragment fragment) {
        fragments.add(fragment);
    }

}