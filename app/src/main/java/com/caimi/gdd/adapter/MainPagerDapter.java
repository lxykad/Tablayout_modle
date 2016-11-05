package com.caimi.gdd.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class MainPagerDapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles;

    public MainPagerDapter(FragmentManager fm, ArrayList<Fragment> list, String[] titles) {
        super(fm);
        mFragments = list;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
