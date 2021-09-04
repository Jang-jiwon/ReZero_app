package com.example.rezero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Kitchen extends AppCompatActivity {

    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        mContext = getApplicationContext();

        //탭레이아웃
        {mTabLayout = (TabLayout) findViewById(R.id.layout_tab);

            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("상품")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("디자이너")));

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

    //텝뷰
    private View createTabView(String tabName) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;
    }
}