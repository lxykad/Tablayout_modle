package com.caimi.gdd.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class MainTab implements CustomTabEntity {

    public String mTitle;
    public int mSelectedIcon;
    public int mUnSelectedIcon;

    public MainTab(String title, int selectedIcon, int unSelectedIcon) {
        this.mTitle = title;
        this.mSelectedIcon = selectedIcon;
        this.mUnSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return mTitle;
    }

    @Override
    public int getTabSelectedIcon() {
        return mSelectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return mUnSelectedIcon;
    }
}
