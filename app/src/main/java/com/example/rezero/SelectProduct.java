package com.example.rezero;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import me.relex.circleindicator.CircleIndicator;

public class SelectProduct extends AppCompatActivity {
    ScrollView scroll;
    Button butBtn,intent_designer;


    ImageButton backBtn;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        backBtn = (ImageButton)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewPager viewPager = (ViewPager) findViewById(R.id.pagerBanner);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        ProductImgAdapter adapter = new ProductImgAdapter(getSupportFragmentManager());//탭레이아웃대신 서클 인디케이터
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        //탭레이아웃
        {mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

            mTabLayout.addTab(mTabLayout.newTab().setText("디테일"));
            mTabLayout.addTab(mTabLayout.newTab().setText("리뷰"));


            mViewPager = (ViewPager) findViewById(R.id.viewPager2);
            SelectProVPager mContentsPagerAdapter = new SelectProVPager(
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

        //구매하기 바텀시트
        butBtn = (Button) findViewById(R.id.buyBtn);
        butBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuyBtnBottomSheetDialog bottomSheetDialog = new BuyBtnBottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });


        //디자이너버튼
        Intent move_designer = new Intent(getApplicationContext(),Designer.class);
        intent_designer=(Button) findViewById(R.id.intent_designer);
        intent_designer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(move_designer);
            }
        });


    }
}