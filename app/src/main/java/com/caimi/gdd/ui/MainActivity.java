package com.caimi.gdd.ui;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.caimi.gdd.R;
import com.caimi.gdd.adapter.MainPagerDapter;
import com.caimi.gdd.databinding.ActivityMainBinding;
import com.caimi.gdd.entity.MainTab;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private String[] mTitles = {"首页", "自选", "资讯", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();

    }

    private void initData() {
        mFragments.add(new HomeFragment());
        mFragments.add(new StockFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new UserCenterFragment());
        //
        mBinding.viewPager.setAdapter(new MainPagerDapter(getSupportFragmentManager(), mFragments, mTitles));

        for (int i = 0; i < mTitles.length; i++) {
            mTabList.add(new MainTab(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mBinding.tabLayout.setTabData(mTabList);
        //
        mBinding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mBinding.viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        //
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBinding.tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBinding.viewPager.setCurrentItem(0);

    }
}
