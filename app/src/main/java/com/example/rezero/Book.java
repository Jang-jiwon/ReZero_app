package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Book extends AppCompatActivity {

    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        mContext = getApplicationContext();

        //탭레이아웃
        {mTabLayout = (TabLayout) findViewById(R.id.layout_tab);

            mTabLayout.addTab(mTabLayout.newTab().setText("상품"));
            mTabLayout.addTab(mTabLayout.newTab().setText("디자이너"));

            mViewPager = (ViewPager) findViewById(R.id.pager_content);
            CategoryAdapter mContentsPagerAdapter = new CategoryAdapter(
                    getSupportFragmentManager(), mTabLayout.getTabCount());
            mViewPager.setAdapter(mContentsPagerAdapter);

            mViewPager.addOnPageChangeListener(
                    new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });}


    }
}